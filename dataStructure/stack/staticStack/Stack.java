package stack.staticStack;

import javaRepositories.Print;

public class Stack {
    private int top;
    private int capacity;
    private Object stack[];

    public Stack(int capacity){
        Print.print("Static InverseStackMain was created.");
        stack = new Object[capacity];
        top = 0;
    }

    public void push(Object o) {
        if(isFull() == false) {
            stack[top] = o;
            top = top + 1;
            Print.print("Added element " + o + " to stack in the position " + top);
            Print.print("The top value now is: " + top);
        } else {
            Print.print("The stack is full!");
        }
    }

    public Object pop() {
        if(isEmpty() == false) {
            top = top - 1;
            if(top == 0) {
                Print.print("The stack is empty!");
            } else {
                Print.print("Removed element " + stack[top] + " from stack in the position " + top);
            }
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

    public void list() {
        Print.print("Starting listing... ");
        for (int i = top - 1; i >= 0; i--) {
            Print.print("Value in " + i + " " + stack[i]);
        }
        Print.print("Endend.\n");
    }

    public void clear() {
        Print.print("");
        while(isEmpty() == false) {
            Print.print("" + stack[top]);
            pop();
        }
        Print.print("The stack is clean!");
    }
}
