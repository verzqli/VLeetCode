package me.verzqli.leetcode.dp;

import java.util.HashMap;
import java.util.Map;

class LeetCode523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        //连续数组求和考虑前缀和前缀和

        Map<Integer, Integer> map = new HashMap();
        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int temp = k == 0 ? sum : sum % k;
            if (map.containsKey(temp)) {
                //这里大于1是区间减去区间的元音
                if (i - map.get(temp) > 1) {
                    return true;
                }

            }
            map.put(temp, i);
        }
        return false;
    }
}
