package me.verzqli.leetcode.prefix;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * <p>
 * 示例:
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
class LeetCode001 {
    public static void main(String[] args) {
    }

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        if (nums.length < 1) {
            return result;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = map.getOrDefault(target - nums[i], 0);
            if (temp != 0) {
                result[0] = temp-1;
                result[1] = i;
                break;
            } else {
                map.put(nums[i], i+1);
            }
        }
        return result;
    }

}
