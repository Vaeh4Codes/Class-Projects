package cmsc256;

import java.util.EmptyStackException;

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
public class MyStack<E> implements MyStackInterface<E> {
    private Object[] array;
    private int capacity;
    private int top;

    public MyStack(){
        this.capacity = 9;
        this.top = -1;
        this.array = new Object[capacity];
    }

    public MyStack(Object[] array, int capacity){
        this.capacity = capacity;
        this.top = -1;
        this.array = array;
    }

    public static void main(String[] args){

    }

    public void push(E item){
        if(top == capacity-1){
            //Handles resizing
            capacity = capacity * 2;
            Object[] bigger = new Object[capacity];
            for (int k = 0; k <= top; k++) {
                bigger[k] = array[k];
            }
            array = bigger;
        }else{
            array[++top] = item;
        }
    }


    public E pop() throws java.util.EmptyStackException{
        if(array == null){
            throw new EmptyStackException();
        }
        E item = (E) array[top];
        top --;
        return item;

    }

    public E peek(){
        if(top < 0 ){
            throw new EmptyStackException();
        }
        return (E) array[top];
    }

    public boolean isEmpty(){
        if(top >= 0){
            return true;
        }else{
            return false;
        }
    }

    public int size(){
        return top+1;
    };
}
