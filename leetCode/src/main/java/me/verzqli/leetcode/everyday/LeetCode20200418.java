package me.verzqli.leetcode.everyday;

public class LeetCode20200418 {
    public static void main(String[] args) {

    }

    public int maxArea(int[] height) {
        if (height.length <= 1) {
            return 0;
        }
        int start = 0;
        int end = height.length - 1;
        int max = 0;
        while (start < end) {
            if (height[start] > height[end]) {
                max = Math.max(max, height[end] * (end - start));
                end--;
            } else {
                max = Math.max(max, height[start] * (end - start));
                start++;
            }
        }
        return max;
    }

}
