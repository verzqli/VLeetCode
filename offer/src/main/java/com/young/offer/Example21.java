package com.young.offer;

import java.util.Deque;
import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的min函数。在该栈中，调用min、push及pop的时间复杂度都是0(1)
 */
public class Example21 {
    Stack<Integer> dataStack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public static void main(String[] args) {

    }

    public void push(int x) {
        if (dataStack.empty()) {
            dataStack.push(x);
            minStack.push(x);
        } else {
            int min = minStack.peek();
            dataStack.push(x);
            minStack.push(Math.min(x, min));
        }
    }

    public void pop() {
        dataStack.pop();
        minStack.pop();
    }

    public int top() {
        return dataStack.peek();
    }

    public int min() {
        return minStack.peek();
    }

}
