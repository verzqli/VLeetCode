package me.verzqli.leetcode.everyday;

import java.util.HashMap;
import java.util.Map;

public class LeetCode20200515 {
    public static void main(String[] args) {
    }

    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int count=0;
        int temp=0;
        for (int i = 0; i < nums.length; i++) {
            temp+=nums[i];
            //如果当前累加前缀值等于k，就加一
            if (temp==k){
                count++;
            }
            //例如temp=15，k为4,如果前面出现过11的前缀和，那么肯定存在和为K的数组，
            // 数量就等于前面出现前缀和为11的次数
            if (map.containsKey(temp-k)){
                count+=map.get(temp-k);
            }
            //如果map中不存在这个前缀和就加1，如果存在就加1
            map.put(temp,map.getOrDefault(temp,0)+1);

        }
        return count;
    }

}
