package me.verzqli.leetcode.everyday;

import java.util.Random;

class LeetCode20200629 {
    Random random = new Random();

    public int findKthLargest(int[] nums, int k) {
//        int start = 0;
//        int end = nums.length - 1;
//        int length = nums.length;
//        int center = quickSort(nums, start, end);
//        k = length - k;
//        if (center > k) {
//            center = quickSort(nums, start, center - 1);
//        } else {
//            center = quickSort(nums, center + 1, end);
//        }
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    public int quickSelect(int[] a, int l, int r, int index) {
        //这个随机速度能快上十几倍。
        int q = randomPartition(a, l, r);
        if (q == index) {
            return a[q];
        } else {
            return q < index ? quickSelect(a, q + 1, r, index) : quickSelect(a, l, q - 1, index);
        }
    }


    public int randomPartition(int[] a, int l, int r) {
        int i = random.nextInt(r - l + 1) + l;
        swap(a, i, r);
        return partition(a, l, r);
    }

    public int partition(int[] a, int l, int r) {
        int x = a[r], i = l - 1;
        for (int j = l; j < r; ++j) {
            if (a[j] <= x) {
                swap(a, ++i, j);
            }
        }
        swap(a, i + 1, r);
        return i + 1;
    }

    private void swap(int[] nums, int low, int high) {
        int temp = nums[low];
        nums[low] = nums[high];
        nums[high] = temp;

    }
}
