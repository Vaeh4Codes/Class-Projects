# Project 3 – PromptML Parser

This project will challenge you to apply your understanding of stacks to a practical problem: validating the structure of a custom markup language. The crucial part of this assignment is that you will **design and implement your own stack data structure** from scratch, rather than relying on Java's built-in Stack or Deque classes. This will give you a deeper appreciation for how these fundamental structures work.

## Objective

To design and implement a Java program that reads a file containing "PromptML" (a simplified XML-like markup for AI prompts), validates its tag balance and nesting using a custom-built stack data structure, and reports any structural errors.

## Background

Structured data formats are ubiquitous in computing, and ensuring their correctness is vital. XML (Extensible Markup Language) is a common example, where tags must be properly opened, closed, and nested. For instance, in `<parent><child></child></parent>`, `<child>` is correctly nested within `<parent>`. However, `<parent><child></parent></child>` is invalid because the closing tags are out of order.

A stack is an ideal data structure for validating such nested structures. As you encounter an opening tag, you push it onto the stack. When you encounter a closing tag, you pop from the stack and check if it matches the expected closing tag. If they don't match, or if the stack is empty when a closing tag appears, or if the stack is not empty at the end of the file, then the document is structurally invalid.

For this assignment, we will use a simplified markup language I'm calling "PromptML." It will mimic the essential features of XML for validation purposes.

## PromptML Format

PromptML files will contain a sequence of elements. Each element consists of:

- **Opening Tag:** `<tagName>` or `<tagName attribute="value">`
- **Closing Tag:** `</tagName>`
- **Self-Closing Tag:** `<tagName/>` or `<tagName attribute="value"/>`
- **Content:** Text content between opening and closing tags.
- **Comments:** `<!-- This is a comment -->` (These should be ignored by your parser).

### Example PromptML Structure

```xml
<prompt id="1">
    <text>Generate a short story about a robot discovering art.</text>
    <parameters>
        <model>gemini-1.5-flash</model>
        <temperature>0.7</temperature>
        <max_tokens>500</max_tokens>
    </parameters>
    <image/> <!-- Optional image placeholder -->
</prompt>

<!-- Another prompt example -->
<prompt id="2" type="creative">
    <text>Write a poem about the ocean.</text>
</prompt>
```

## Project Structure and Requirements

- Your project should consist of two main files: your custom stack implementation and the PromptML validator.
- You are required to implement a custom stack and a validator class that uses your custom stack.
- You may not use the `java.util.Stack` class.
- You may not use regular expressions (if unsure if something is a regex, ask your instructor or TA).
- You must include a main method **INSIDE** your `MyStack.java` class that tests your implementation of the `MyStackInterface.java`.
- You must include a main method **INSIDE** your `PromptMLValidator.java` class that tests your implementation of the `PromptMLValidator` class.

### 1. MyStack.java – Custom Stack Implementation

Implement the generic `MyStackInterface.java`, available here:

- [MyStackInterface.java](https://virginiacommonwealth.instructure.com/courses/137460/files/19440478?verifier=u0hugscwNuKaf1cRSt6PInGVRmKxCSkLnBf0P8v3&wrap=1)
- [Download MyStackInterface.java](https://virginiacommonwealth.instructure.com/courses/137460/files/19440478/download?verifier=u0hugscwNuKaf1cRSt6PInGVRmKxCSkLnBf0P8v3&download_frd=1)

The name of your implementation file MUST be **MyStack.java**. You MUST NOT use `java.util.Stack` or `java.util.Deque` for the core stack logic. You will implement your own stack. You can choose to implement it using an array or a linked list internally.

### 2. PromptMLValidator.java

This class will contain the logic for parsing the PromptML file and use your `MyStackInterface` implementation to validate its structure. Here is the starter file to use:

- [PromptMLValidator.java](https://virginiacommonwealth.instructure.com/courses/137460/files/19440216?verifier=HC3A8s2K7xKf57tpQnQRDojFfxDwWXiUW3miv9s4&wrap=1)
- [Download PromptMLValidator.java](https://virginiacommonwealth.instructure.com/courses/137460/files/19440216/download?verifier=HC3A8s2K7xKf57tpQnQRDojFfxDwWXiUW3miv9s4&download_frd=1)

### Ambiguity and Discussion Points

Consider the following in your design and discuss them in your README file:

- **Custom Stack Implementation:** Will you use an array-based or linked-list based approach for your MyStack? What are the trade-offs of each for this specific application? How will you handle resizing if you choose an array-based implementation?
- **Error Reporting Detail:** How specific should your error messages be? What are the distinct types of errors you need to report (e.g., unmatched opening, unmatched closing, incorrect nesting order, unexpected content outside tags)?
- **Parsing Strategy:** How will you read the file and identify tags? Will you read line by line, or character by character?
- **Tag Name Validity:** What characters are allowed in a tagName?
- **Whitespace:** How will your parser handle whitespace around tags (e.g., `< tag >` vs. `<tag>`)?

## Deliverables

1. **Your Java source code:** This should include your `MyStackInterface` implementation, `MyStack.java`, and `PromptMLValidator.java`. Organize your code into appropriate packages.
2. **A brief README file:** Submitted to Gradescope with your source code. This plain text file should:
    - Explain your chosen internal implementation for `MyStackInterface` (array vs. linked list) and justify your choice.
    - Describe your parsing strategy for the PromptML file.
    - Discuss the types of errors your validator identifies and how your error messages are formatted.
    - Provide instructions on how to compile and run your program.
    - *Be completely written by you, without the aid of anyone or an AI. Failure to follow this rule will disqualify your submission.*

## Grading Rubric

- **Custom Stack Correctness:** Your `MyStackInterface` implementation must correctly implement all specified methods and behave as expected for a stack, including handling `EmptyStackException`.
- **Validation Logic Correctness:** Your `PromptMLValidator` must correctly identify all structural errors (unmatched tags, incorrect nesting) and correctly validate valid files. This will be heavily weighted by unit tests.
- **Error Reporting:** Your `getValidationErrors()` method must provide clear, concise, and accurate error messages.
- **Code Quality:** This includes good object-oriented design, clean and readable code, meaningful variable names, and proper commenting where necessary.
- **README and Design Discussion:** Clarity and thoughtfulness in explaining your design choices and addressing the ambiguous points.

## Getting Started

1. Start by implementing your `MyStackInterface` interface. Test it thoroughly before moving on.
2. Familiarize yourself with Java's file I/O (e.g., `BufferedReader`, `FileReader`).
3. Think about how you will parse the file content to identify tags. String methods like `indexOf`, `substring`, `startsWith`, and `endsWith` will be very useful.
4. Create a few sample PromptML files (valid and invalid) to test your validator as you build it.

**Important Note:** This is an individual assignment. While you are encouraged to discuss concepts and general approaches with your classmates, all code must be your own original work. Plagiarism will not be tolerated.

Write this program in **Java version 11**. It is expected that your program will be well documented. Follow all commenting conventions discussed in class, including a comment block at the top of your file with your name, date, the course number and section, program purpose, etc.

You will submit the Java source code files (`MyStack.java` & `PromptMLValidator.java`) to the Gradescope assignment link for the programming project.

Ask questions on the Canvas Discussion Board about any part of the programming project that is not clear!