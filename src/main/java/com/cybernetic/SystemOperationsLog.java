package com.cybernetic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SystemOperationsLog {
    private SystemOperation[] stack;
    private int head = 0;

    public SystemOperationsLog(int size) {
        stack = new SystemOperation[size];
    }

    public void pushOperation(SystemOperation op) {
        stack[head] = op;
        head++;
    }

    public SystemOperation popLastOperation() {
        head--;
        return stack[head + 1];
    }

    public SystemOperation peekLastOperation() {
        return stack[head];
    }

    public List<SystemOperation> getRecentOperations(int length) {
        return new ArrayList<SystemOperation>(Arrays.asList(Arrays.copyOfRange(stack, length, stack.length)));
    }
}
