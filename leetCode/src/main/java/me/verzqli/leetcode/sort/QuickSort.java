package me.verzqli.leetcode.sort;

public class QuickSort {
    public static void main(String[] args) {
        System.out.printf("" + (new QuickSort().solve(new int[]{3, 7, 4, 1, 2, 6})));
    }

    public int[] solve(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        quickSort(nums, left, right, nums[0]);
        return nums;
    }

    private void quickSort(int[] nums, int l, int r, int temp) {
        if (l==r){
            return;
        }
        int left = l;
        int right = r;
        while (left < right) {
            while (nums[right] >= temp && left < right) {
                right--;
            }
            nums[left] = nums[right];
            left++;

            while (nums[left] <= temp && left < right) {
                left++;
            }
            nums[right] = nums[left];
            right--;
        }

        nums[left] = temp;
        quickSort(nums, l, left, nums[0]);
        quickSort(nums, left + 1, r, nums[left + 1]);

    }

}
