package me.verzqli.leetcode.everyday;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LeetCode20200608 {
    public static void main(String[] args) {
    }

    public int longestConsecutive(int[] nums) {
        //最近又忘了
        if (nums==null||nums.length==0){
            return 0;
        }
        Map<Integer,Integer> map = new HashMap<>();
        int result = 1;
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],1);
        }
        for (int i = 0; i < nums.length; i++) {
           if (!map.containsKey(nums[i]-1)){
               int curNum = nums[i];
               int curCount = 1;
               while (map.containsKey(curNum+1)){
                   curNum++;
                   curCount++;
               }
               result=Math.max(result,curCount);
           }
        }
        return  result;
    }

}
