package com.young.offer;

/**
 * 面试题53 - I. 在排序数组中查找数字 I
 * 统计一个数字在排序数组中出现的次数。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 */
public class Example38 {
    public static void main(String[] args) {

    }
    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        int firstIndex = findFirst(nums, 0, nums.length - 1, target);
        int lastIndex = findLast(nums, 0, nums.length - 1, target);
        if (firstIndex>=0&&lastIndex>=0){
            return lastIndex-firstIndex+1;
        }
        return 0;
    }

    private int findFirst(int[] nums, int left, int right, int target) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (nums[mid] == target) {
            //我想到了在不同情况下判断前一个或者后一个来判断这是否是要求的下标，
            //但是判断是否等于左边界和下面的有边界是我没想到的
            if (mid == 0 || (nums[mid - 1] != target)) {
                return mid;
            } else {
                right = mid - 1;
            }
        } else if (nums[mid] > target) {
            right = mid - 1;
        } else {
            left = mid + 1;
        }
        return findFirst(nums, left, right, target);
    }

    private int findLast(int[] nums, int left, int right, int target) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (nums[mid] == target) {
            if (mid == nums.length - 1 || (nums[mid + 1] != target)) {
                return mid;
            } else {
                left = mid + 1;
            }
        } else if (nums[mid] > target) {
            right = mid - 1;
        } else {
            left = mid + 1;
        }
        return findLast(nums, left, right, target);
    }
}
