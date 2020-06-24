package me.verzqli.leetcode.everyday;

import java.util.Arrays;

class LeetCode20200624 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = Integer.MAX_VALUE;
        int minAbs = Integer.MAX_VALUE;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int low = i + 1;
            int high = length - 1;
            while (low < high) {
                int sum = nums[i] + nums[low] + nums[high];
                int diff = sum - target;
                if (Math.abs(diff) < Math.abs(minAbs)) {
                    result = sum;
                    minAbs = diff;
                }
                if (diff < 0) {
                    while (low < high && nums[low] == nums[low+1]) {
                        low++;
                    }
                    low++;
                } else if (diff > 0) {
                    while (low < high && nums[high] == nums[low-1]) {
                        high--;
                    }
                    high--;
                } else {
                    return sum;
                }
            }
        }
        return result;
    }
}
