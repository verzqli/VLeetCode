package me.verzqli.leetcode.everyday;

/**
 * 209. 长度最小的子数组
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组，并返回其长度。如果不存在符合条件的连续子数组，返回 0。
 *
 * 示例:
 *
 * 输入: s = 7, nums = [2,3,1,2,4,3]
 * 输出: 2
 * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 * 进阶:
 *
 * 如果你已经完成了O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。
 */
class LeetCode20200628 {
    public static void main(String[] args) {
        new LeetCode20200628().minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3});
    }

    public int minSubArrayLen(int s, int[] nums) {

        if (nums.length <= 0) {
            return 0;
        }
        if (s == 1) {
            return 1;
        }
        int left = 0;
        int sum = 0;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; ) {
            sum += nums[i];
            while (sum >= s) {
                sum -= nums[left++];
            }
            res = Math.min(res, i - left+2);
            i++;
        }
        if (res == Integer.MAX_VALUE) {
            return 0;
        }
        return res;
    }
}