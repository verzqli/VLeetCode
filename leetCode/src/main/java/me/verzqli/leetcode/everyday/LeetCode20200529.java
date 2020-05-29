package me.verzqli.leetcode.everyday;

public class LeetCode20200529 {
    public static void main(String[] args) {
    }

    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
//          使用dp数组
//        int dp[] = new int[nums.length];
//        dp[0] = nums[0];
//        dp[1] = Math.max(dp[0], nums[1]);
//        int result = dp[1];
//        for (int i = 2; i < nums.length; i++) {
//            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
//            result = Math.max(result, dp[i]);
//        }
        //优化dp，i_1表示上面的i-1,i_2表示上面的i-2
        //因为dp[i]只依赖前两个，所以这里只用三个参数即可。
        int cur, i_1, i_2;
        i_2 = nums[0];
        i_1 = Math.max(i_2, nums[1]);
        int result = i_1;
        for (int i = 2; i < nums.length; i++) {
            cur = Math.max(i_2 + nums[i], i_1);
            i_2 = i_1;
            i_1 = cur;
            result = Math.max(result, cur);

        }
        return result;
    }

}
