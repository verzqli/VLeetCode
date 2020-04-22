package com.young.offer;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 */
public class Example31 {
    public static void main(String[] args) {
    }

    /**
     * 贪心算法，每一次计算都选择最大的值
     * 每次用前面数组之和加上当前数字，如果和大于当前数字，那么就返回这个大值，然后继续
     * 如果小于当前数字，说明前面是负数，等于舍弃这些数字，从当前数字继续开始加。
     */
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int resultMax = nums[0];
        int curMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            curMax = Math.max(nums[i], curMax + nums[i]);
            resultMax = Math.max(curMax, resultMax);
        }
        return resultMax;
    }

    /**
     * 动态规划
     * 这里的动态规划和上面贪心算法其实差不多，只不过贪心省去了动态规划的数组，用了一个curMax来代替
     */
    public int maxSubArray2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int resultMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] < 0) {
                dp[i] = nums[i];
            } else {
                dp[i] = dp[i - 1] + nums[i];
            }
            resultMax = Math.max(resultMax, dp[i]);
        }
        return resultMax;
    }

}
