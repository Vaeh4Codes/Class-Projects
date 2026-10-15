# **Project 03 Design Decisions** 

**Custom Stack Implementation:** Will you use an array-based or linked-list based approach for your MyStack? What are the trade-offs of each for this specific application? How will you handle resizing if you choose an array-based implementation?
- **Error Reporting Detail:** How specific should your error messages be? What are the distinct types of errors you need to report (e.g., unmatched opening, unmatched closing, incorrect nesting order, unexpected content outside tags)?
- **Parsing Strategy:** How will you read the file and identify tags? Will you read line by line, or character by character?
- **Tag Name Validity:** What characters are allowed in a tagName?
- **Whitespace:** How will your parser handle whitespace around tags (e.g., `< tag >` vs. `<tag>`)?


**Custom Stack Implementation:**
Because this project is primarily focused on validating XML Machine learning Promp XML syntax, and because i'm assuming that the assignment
is focusing on smaller to medium-sized prompts, I will use a an array based stack data strucute. While, linked list allow stacks to not have to be resized,
I don't anticipate that much resizing would be an issue. Also, generalyy, aray based stacks save more on memory than linked lists.

**Error Reporting Detail:**
Some specific errors that I will have to account for include: correct file path, valid tag format, appropriate opening/closing tags.

