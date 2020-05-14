package me.verzqli.leetcode.everyday;

public class LeetCode20200514 {
    public static void main(String[] args) {
        System.out.printf("");
    }

    public int singleNumber(int[] nums) {
        for (int i = 1,length=nums.length; i < length; i++) {
            nums[i]=nums[i-1]&nums[i];
        }
        return nums[nums.length-1];
    }

}
