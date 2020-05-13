package me.verzqli.leetcode.everyday;

import java.util.Stack;

public class LeetCode20200512 {
    Stack<Integer> data = new Stack<>();
    Stack<Integer> minData = new Stack<>();
    public static void main(String[] args) {
    }

    public void push(int x) {
        if (data.isEmpty()){
            data.push(x);
            minData.push(x);
        }else{
            data.push(x);
            if (x>minData.peek()){
                minData.push(minData.peek());
            }else{
                minData.push(x);
            }
        }
    }

    public void pop() {
        data.pop();
        minData.pop();
    }

    public int top() {
       return data.peek();
    }

    public int getMin() {
        return minData.peek();
    }

}
