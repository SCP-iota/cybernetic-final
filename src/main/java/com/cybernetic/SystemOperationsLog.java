package com.cybernetic;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SystemOperationsLog {
    private List<SystemOperation> stack = new ArrayList<>();

    public SystemOperationsLog(int size) { }

    public void pushOperation(SystemOperation op) {
        stack.add(op);
    }

    public SystemOperation popLastOperation() {
        return stack.removeLast();
    }

    public SystemOperation peekLastOperation() {
        return stack.getLast();
    }

    public List<SystemOperation> getRecentOperations(int length) {
        var buf = new ArrayList<SystemOperation>();

        for(int i = 0; i < length; i++) {
            if(stack.isEmpty())
                break;

            buf.add(stack.removeLast());
        }

        for(var op : buf) {
            stack.add(op);
        }

        return buf;
    }
}
