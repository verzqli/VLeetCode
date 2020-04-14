package com.young.offer;

/**
 * 题目:数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3, 2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。
 */
public class Example29 {
    public static void main(String[] args) {
//        new Example29().solve();
    }

    public int solve(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int curNumber = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                curNumber = nums[i];
                count = 1;
            } else {
                if (curNumber == nums[i]) {
                    count++;
                } else {
                    count--;
                }
            }
        }
        return checkNumberIsTure(nums, curNumber) ? curNumber : 0;
    }
    //判断这个数是否是真的中位数
    private boolean checkNumberIsTure(int[] nums, int curNumber) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == curNumber) {
                count++;
            }
        }
        return count * 2 > nums.length;

    }

}
