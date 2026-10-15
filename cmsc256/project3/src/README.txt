Project 03 Design Decisions

Custom Stack Implementation: Will you use an array-based or linked-list based approach for your MyStack? What are the trade-offs of each for this specific application? How will you handle resizing if you choose an array-based implementation?
- Error Reporting Detail:** How specific should your error messages be? What are the distinct types of errors you need to report (e.g., unmatched opening, unmatched closing, incorrect nesting order, unexpected content outside tags)?
- Parsing Strategy:** How will you read the file and identify tags? Will you read line by line, or character by character?
- Tag Name Validity:** What characters are allowed in a tagName?
- Whitespace:** How will your parser handle whitespace around tags (e.g., `< tag >` vs. `<tag>`)?


Custom Stack Implementation:
Since this project validates PromptML syntax, and I'm assuming the input files are small to medium-sized prompts,
I chose an array-based stack. A linked list avoids resizing, but I don't expect resizing to be a problem at this scale.
Array-based stacks also generally use less memory than linked lists, since they don't store a reference for every node.

Error Reporting Detail:
My validator needs to handle three kinds of errors: an invalid or missing filepath, malformed tags, and unbalanced or mismatched opening and closing tags. Each error is stored in a list with a descriptive message, including the line
number, and is available through getValidationErrors().

Tag Name Validity: What characters are allowed in a tagName?
- Whitespace: How will your parser handle whitespace around tags (e.g., `< tag >` vs. `<tag>`)?
A tag with empty space will be trimmed. White space of the '/' character will not be considered a part of a tag name.