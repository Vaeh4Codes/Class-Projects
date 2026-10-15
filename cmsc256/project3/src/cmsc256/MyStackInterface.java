package cmsc256; 


public interface MyStackInterface<E> {

    /**
     * Pushes an item onto the top of this stack.
     * @param item The item to be pushed onto the stack.
     */
    void push(E item);

    /**
     * Removes the object at the top of this stack and returns that object as the value of this function.
     * @return The object at the top of this stack.
     * @throws java.util.EmptyStackException If this stack is empty.
     */
    E pop();

    /**
     * Looks at the object at the top of this stack without removing it from the stack.
     * @return The object at the top of this stack.
     * @throws java.util.EmptyStackException If this stack is empty.
     */
    E peek();

    /**
     * Tests if this stack is empty.
     * @return true if and only if this stack contains no items; false otherwise.
     */
    boolean isEmpty();

    /**
     * Returns the number of items in this stack.
     * @return The number of items in this stack.
     */
    int size();
}
