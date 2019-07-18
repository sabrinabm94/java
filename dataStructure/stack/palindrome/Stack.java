package stack.palindrome;

import javaRepositories.Print;

public class Stack {
    private int top;
    private Object stack[];

    public Stack(int capacity){
        System.out.println("The stack was created!");
        stack = new Object[capacity];
        top = 0;
    }

    public void push(Object o) {
        if(isFull() == false) {
            Print.print("Added element " + o + " in stack...");
            stack[top] = o;
            top = top + 1;
            Print.print("The top is " + top);
        } else {
            Print.print("The stack is full!");
        }
    }

    public Object pop() {
        if(isEmpty() == false) {
            top = top - 1;
            if(top == 0) {
                System.out.println("The stack is empty!");
            }
            Print.print("Removing the last element of stack...");
            Print.print("The top is " + top);
            return stack[top];
        } else {
            return null;
        }
    }

    public boolean isFull() {
        if(top == stack.length){
            return true;
        } else {
            return false;
        }

    }

    public boolean isEmpty() {
        if(top == 0){
            return true;
        } else {
            return false;
        }
    }

    public void clear() {
        while(isEmpty() == false){
            pop();
        }
    }

    public void list() {

    }
}
