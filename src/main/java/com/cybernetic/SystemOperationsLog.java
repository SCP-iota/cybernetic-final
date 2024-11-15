package com.cybernetic;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SystemOperationsLog {
    private Stack<SystemOperation> stack = new Stack<>();

    public SystemOperationsLog(int size) { }

    public void pushOperation(SystemOperation op) {
        stack.push(op);
    }

    public SystemOperation popLastOperation() {
        return stack.pop();
    }

    public SystemOperation peekLastOperation() {
        return stack.peek();
    }

    public List<SystemOperation> getRecentOperations(int length) {
        var buf = new ArrayList<SystemOperation>();

        for(int i = 0; i < length; i++) {
            if(stack.isEmpty())
                break;
                
            buf.add(stack.pop());
        }

        for(var op : buf) {
            stack.push(op);
        }

        return buf;
    }
}
