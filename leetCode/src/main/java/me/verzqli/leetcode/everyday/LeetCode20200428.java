package me.verzqli.leetcode.everyday;

public class LeetCode20200428 {
    public static void main(String[] args) {
    }

    public int[] singleNumbers(int[] nums) {
        int sum = 0;
        int[] res = new int[2];
        for(int num : nums){
            sum ^= num;
        }
        int lowbit = sum & (-sum);
        for(int num : nums){
            if((num & lowbit) == 0){
                res[0] ^= num;
            }else{
                res[1] ^= num;
            }
        }
        return res;
    }
}
