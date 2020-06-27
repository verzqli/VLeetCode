package me.verzqli.leetcode.everyday;

/**
 * @author verzqli
 * @date 2020/6/27
 * @Desc
 */
class LeetCode20200627 {
    public int firstMissingPositive(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            while (nums[i]>0&&nums[i]<=length&&nums[nums[i]-1]!=nums[i]){
                swap(nums,nums[i]-1,i);
            }
        }
        for (int i = 0; i < length; i++) {
            if (nums[i]!=i+1){
                return i+1;
            }
        }

        return length+1;
    }

    private void swap(int[] nums, int num, int i) {
        int temp = nums[num];
        nums[num]=nums[i];
        nums[i]=temp;
    }
}
