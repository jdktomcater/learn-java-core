package com.jdktomcat.pack.dsa.algorithm.company.mihoyo.easy;

import java.util.Stack;

/**
 * 用栈实现队列
 */
public class MyQueue {

    Stack<Integer> in = new Stack<>();
    Stack<Integer> out = new Stack<>();

    public MyQueue() {

    }

    public void push(int x) {
        while(!in.isEmpty()){
            out.push(in.pop());
        }
        in.push(x);
        while(!out.isEmpty()){
            in.push(out.pop());
        }
    }

    public int pop() {
        if(in.empty()){
            return -1;
        }
        return in.pop();
    }

    public int peek() {
        if(in.empty()){
            return -1;
        }
        return in.peek();
    }

    public boolean empty() {
        return in.isEmpty();
    }

}
