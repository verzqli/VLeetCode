package me.verzqli.leetcode.everyday;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author verzqli
 * @date 2020/5/30
 * @Desc
 */
class LeetCode20200530 {
    public static void main(String[] args) {

    }

    public int largestRectangleArea(int[] heights) {
        int length = heights.length;
        if (length==0){
            return 0;
        }
        if (length==1){
            return heights[0];
        }
        int[] newHeight = new int[length+2];
        Deque<Integer> stack =new ArrayDeque<>();
        for (int i = 1; i <= length; i++) {
            newHeight[i] = heights[i-1];
        }
        stack.addLast(0);
        int a =stack.peekLast();
        int result =0;
        for (int i = 1; i < length+2; i++) {
            while (newHeight[stack.peekLast()]>newHeight[i]){
                int maxheight = newHeight[stack.pollLast()];
                int maxWigth = i-stack.peekLast()-1;
                result=Math.max(result,maxheight*maxWigth);
            }
            stack.add(i);
        }
        return result;
    }
}
