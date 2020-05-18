package me.verzqli.leetcode.everyday;

public class LeetCode20200518 {
    public static void main(String[] args) {
        new LeetCode20200518().maxProduct(new int[]{2, 3, -2, 4});
    }

    public int maxProduct(int[] nums) {

        int maxDp = nums[0];
        int minDp = nums[0];
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int max = maxDp;
            int min = minDp;
            maxDp = Math.max(max * nums[i], Math.max(min * nums[i], nums[i]));
            minDp = Math.min(max * nums[i], Math.min(min * nums[i], nums[i]));
            //第一个注意点，这里最后答案不是求maxdp和mindp之间的最大值，而是引入了result
            result = Math.max(maxDp, result);
        }
        return result;
    }
}
//    int maxDp[] = new int[nums.length];
//    int minDp[] = new int[nums.length];
//        maxDp[0] = nums[0];
//                minDp[0] = nums[0];
//                int result= nums[0];
//                for (int i = 1; i < nums.length; i++) {
//        maxDp[i] = Math.max(maxDp[i-1]*nums[i],Math.max(minDp[i-1]*nums[i],nums[i]));
//        minDp[i] = Math.min(maxDp[i-1]*nums[i],Math.min(minDp[i-1]*nums[i],nums[i]));
//        result = Math.max(maxDp[i],result);
//        }
//        return result;