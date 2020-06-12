package me.verzqli.leetcode.slidewindow;

import java.util.ArrayDeque;
import java.util.Deque;

class LeetCode239 {
    public static void main(String[] args) {
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 1) {
            return nums;
        }
        int result[] = new int[nums.length - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.addLast(i);
            if (!deque.isEmpty() && i - deque.peekFirst() + 1 > k) {
                deque.pollFirst();
            }
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return result;
    }

}
