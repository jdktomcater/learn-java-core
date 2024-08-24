package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance.finance.easy;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 用栈实现队列
 */
public class MyStackQueue {

    Deque<Integer> inStack = new LinkedList<>();
    Deque<Integer> outStack = new LinkedList<>();

    public MyStackQueue() {}

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        // 如果outStack栈为空，则将inStack栈全部弹出并压入outStack栈中，然后b.pop()
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        return outStack.pop();
    }

    public int peek() {
        // 如果outStack栈为空，则将inStack栈全部弹出并压入outStack栈中，然后b.pop()
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        return outStack.peek();
    }

    public boolean empty() {
        return outStack.isEmpty() && inStack.isEmpty();
    }

}
