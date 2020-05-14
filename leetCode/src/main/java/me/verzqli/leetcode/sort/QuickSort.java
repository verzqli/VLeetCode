package me.verzqli.leetcode.sort;

public class QuickSort {
    public static void main(String[] args) {
        System.out.printf("" + (new QuickSort().solve(new int[]{5, 1, 1, 2, 0, 0})));
    }

    public int[] solve(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        quickSort2(nums, left, right);
        return nums;
    }

    private void quickSort(int[] nums, int l, int r) {
        if (l>=r){
            return;
        }
        int left = l+1;
        int right = r;
        while (left<=right){
            if (nums[left]>nums[l]){
                swap(nums,left,right);
                right--;
            }else{
                left++;
            }
        }
        left--;
        swap(nums,left,l);
        quickSort(nums,l,left-1);
        quickSort(nums,left+1,r);

    }
    private void quickSort2(int[] nums, int l, int r) {
        if (l>=r){
            return;
        }
        int temp = nums[l];
       int low = l;
        int high = r;
        while (low<high){
            while (nums[high]>temp&&low<high){
                high--;
            }
            while (nums[low]<temp&&low<high){
                low++;
            }
            //不做这个判断过滤就超时了
            if (nums[low]==nums[high]&&low<high){
                low++;
            }else{
                swap(nums,low,high);
            }
        }
        quickSort(nums,l,low-1);
        quickSort(nums,high+1,r);

    }
    private void swap(int[] nums, int left, int right) {
        int temp=nums[left];
        nums[left]=nums[right];
        nums[right]=temp;
    }

}
