package com.WiltonZhan.leetcode.l341MinStack;


import java.util.Deque;
import java.util.LinkedList;

public class MinStack {
    private Deque<Integer> stack;
    private Deque<Integer> minValueStack;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new LinkedList<>();
        minValueStack = new LinkedList<>();
    }

    public void push(int x) {
        stack.push(x);
        if (minValueStack.isEmpty()) {
            minValueStack.push(x);
        } else if (minValueStack.peekFirst() > x) {
            minValueStack.push(x);
        } else {
            minValueStack.push(minValueStack.peekFirst());
        }
    }

    public void pop() {
        stack.pop();
        minValueStack.pop();
    }

    public int top() {
        Integer top = stack.peekFirst();
        if (top != null) {
            return top;
        }
        return 0;
    }

    public int getMin() {
        Integer top = minValueStack.peekFirst();
        if (top != null) {
            return top;
        }
        return 0;
    }
}
