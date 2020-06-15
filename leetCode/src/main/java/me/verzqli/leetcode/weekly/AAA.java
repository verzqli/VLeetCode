package me.verzqli.leetcode.weekly;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @author verzqli
 * @date 2020/6/14
 * @Desc
 */
class AAA {
    public int[] runningSum(int[] nums) {
        int [] result = new int[nums.length];
        result[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result[i]=result[i-1]+nums[i];
        }
        return result;
    }

}
