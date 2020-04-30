package me.verzqli.leetcode.everyday;

public class LeetCode20200427 {
    public static void main(String[] args) {
        new LeetCode20200427().search(new  int[]{1},2);
    }

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        return find(nums, 0, nums.length - 1, target);
    }

    private int find(int[] nums, int start, int end, int target) {
        if (start > end) {
          return -1;
        }
        int mid = (start + end) / 2;
        if (nums[mid] == target) {
            return mid;
        }
        //如果start<mid,说明[start,mid]一定是递增序列
        if (nums[start] <= nums[mid]) {
            //如果目标值大于start小于mid，就一定在头部的递增序列中
            if (target >= nums[start] && target <= nums[mid]) {
                return find(nums, start, mid, target);
            } else {
                return find(nums, mid + 1, end, target);
            }
        } else {
            //如果start>mid，说明，mid一定在后面的那个递增序列，即(mid,end]递增
            //如果目标值在这个区间，那么继续mid+1遍历，否子啊就在前面区间
            if (target > nums[mid] && target <= nums[end]) {
                return find(nums, mid + 1, end, target);
            } else {
                return find(nums, start, mid, target);
            }
        }
    }

}
