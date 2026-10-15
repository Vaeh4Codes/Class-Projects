package cmsc256;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List; // For reporting errors
import java.util.Scanner;

/**
 * Program Purpose: to challenge and apply my understanding of stacks to a practical problem: validating the structure of a custom markup language.
 * The crucial part of this assignment is that you will design and implement your own stack data structure from scratch,
 * rather than relying on Java's built-in Stack or Deque classes.
 * This will give you a deeper appreciation for how these fundamental structures work.
 *
 * CMSC 256 Section 002
 * @author Nevaeh Dickerson
 * @date 10/04/26
 *
 */
public class PromptMLValidator {

    private MyStack<String> tagStack; // To store opening tag names

    // You will also need a list to store validation errors
    private List<String> validationErrors;

    public PromptMLValidator() {
        // Initialize your custom stack and error list
        tagStack = new MyStack<>();
        validationErrors = new ArrayList<>();
    }

    public static void main(String[] args){

    }

    /**
     * Reads the PromptML file, parses it, and validates its tag balance and nesting.
     * All errors found during validation should be stored internally and accessible
     * via getValidationErrors().
     *
     * @param filePath The path to the PromptML file.
     * @return true if the file is structurally valid, false otherwise.
     * @throws IllegalArgumentException If unable to open the file or file does not exist.
     */
    public boolean validateFile(String filePath) throws IOException {
        // Implement file reading and parsing logic here.
        // As you encounter tags, use your 'tagStack' to perform validation.
        // Remember to handle comments and attributes correctly (i.e., ignore them for balancing).
        // Populate 'validationErrors' with descriptive messages.
        tagStack = new MyStack<>();
        validationErrors = new ArrayList<>();

        StringBuilder strings = new StringBuilder();
        try(Scanner scanner = new Scanner(new File(filePath))){
            while(scanner.hasNextLine()){
                strings.append(scanner.nextLine()).append("\n");
            }
        }catch(FileNotFoundException e){
            throw new IllegalArgumentException("Unable to open the provided file.");
        }

        String fileText = strings.toString();

        int line = 1;
        int i = 0;

        while(i < fileText.length()){
            char c = fileText.charAt(i);

            if(c == '\n'){
                line++;
                i++;
            }else if(c != '<'){
                i++;
            }else if(fileText.startsWith("<!--", i)) {
                int closing = fileText.indexOf("-->", i + 4);
                if (closing == -1) {
                    validationErrors.add("Error occurred at line " + fileText + ": an unclosed comment.");
                    break;
                }
                for (int k = i; k < closing; k++) {
                    if (fileText.charAt(k) == '\n'){
                        line++;
                    }
                }
                i = closing + 3;
            }else{
                int tagLine = line;
                int j = i+1;
                boolean inQuotes = false;
                char quoteChar = 0;
                while (j < fileText.length()) {
                    char t = fileText.charAt(j);
                    if (t == '\n') line++;
                    if (inQuotes) {
                        if (t == quoteChar) inQuotes = false;
                    } else if (t == '"' || t == '\'') {
                        inQuotes = true;
                        quoteChar = t;
                    } else if (t == '>') {
                        break;
                    }
                    j++;
                }

                if (j >= fileText.length()) {
                    validationErrors.add("Line " + fileText + ": Tag is missing closing '>'.");
                    break;
                }

                String tag = fileText.substring(i, j + 1);

                if(isClosingTag(tag)){
                    String tagName = extractTagName(tag);
                    if(tagStack.isEmpty()){
                        validationErrors.add("Error occurred at line " + tagLine + ": an unexpected closing tag </" + tagName + ">.");
                    }else{
                        String expected = tagStack.pop();
                        if (!expected.equals(tagName)) {
                            validationErrors.add("Error occurred at line " + tagLine + ": Mismatched tag. Expected </"
                                    + expected + "> but found </" + tagName + ">.");
                        }
                    }
                }else if(isOpeningTag(tag)){
                        tagStack.push(extractTagName(tag));
                }
                i = j + 1;
            }
        }
        return validationErrors.isEmpty();
    }

    /**
     * Returns a list of all structural validation errors found during the last call to validateFile().
     * Each string in the list should describe a specific error (e.g., "Unmatched closing tag: </model> at line 10").
     *
     * @return A List of Strings describing the validation errors. Returns an empty list if no errors were found.
     */
    public List<String> getValidationErrors() {
        if(!validationErrors.isEmpty()) {
            return validationErrors; // Return a copy or immutable view
        } else{
            return validationErrors;
        }
    }

    /**
     * (Helper Method - Recommended)
     * Extracts the tag name from a raw tag string (e.g., "<model attribute='value'>" -> "model").
     * Handles both opening and closing tags.
     * @param rawTag The full tag string (e.g., "<prompt>", "</text>", "<image/>").
     * @return The extracted tag name, or null if it's not a valid tag format.
     */
    private String extractTagName(String rawTag) {
        // Implement logic to get "tagName" from "<tagName>", "</tagName>", or "<tagName/>"
        StringBuilder tagText = new StringBuilder(rawTag);
        String tagName = tagText.substring(1, tagText.length() - 1).trim();

        if (rawTag == null || rawTag.charAt(0) != '<'
                || rawTag.charAt(rawTag.length() - 1) != '>') {
            return null;
        }

        if(tagName == null){
            return null;
        }
        if(tagName.startsWith("/")){
            tagName = tagText.substring(1).trim();
        }

        int end = 0;
        while(end < tagName.length() && !Character.isWhitespace(tagName.charAt(end)) && tagName.charAt(end) != '/'){
            end ++;

        }

        return tagName.substring(0, end);
    }

    /**
     * (Helper Method - Recommended)
     * Checks if a given tag string represents a self-closing tag (e.g., "<image/>").
     * @param rawTag The full tag string.
     * @return true if it's a self-closing tag, false otherwise.
     */
    private boolean isSelfClosingTag(String rawTag) {
        // Implement logic to check for "/>" at the end
        if (rawTag == null || rawTag.charAt(0) != '<'
                || rawTag.charAt(rawTag.length() - 1) != '>') {
            return false;
        }

        if(!(rawTag.charAt(rawTag.length() - 1) == '>')){
            return false;
        } else{
            return rawTag.charAt(rawTag.length() - 2) == '/';
        }
    }

    /**
     * (Helper Method - Recommended)
     * Checks if a given tag string represents an opening tag (e.g., "<prompt>").
     * @param rawTag The full tag string.
     * @return true if it's an opening tag, false otherwise.
     */
    private boolean isOpeningTag(String rawTag) {
        // Implement logic to check for "<" at start and not "</" or "/>"
        if (rawTag == null || rawTag.charAt(0) != '<'
                || rawTag.charAt(rawTag.length() - 1) != '>') {
            return false;
        }

        return !(rawTag.charAt(1) == '/' || rawTag.charAt(rawTag.length()-2) == '/');
    }

    /**
     * (Helper Method - Recommended)
     * Checks if a given tag string represents a closing tag (e.g., "</prompt>").
     * @param rawTag The full tag string.
     * @return true if it's a closing tag, false otherwise.
     */
    private boolean isClosingTag(String rawTag) {
        // Implement logic to check for "</" at the start
        if (rawTag == null || rawTag.charAt(0) != '<'
                || rawTag.charAt(rawTag.length() - 1) != '>') {
            return false;
        }

        return rawTag.charAt(1) == '/' || rawTag.charAt(rawTag.length()-2) == '/';
    }
}

