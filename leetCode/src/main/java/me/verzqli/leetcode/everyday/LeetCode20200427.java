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
        //���start<mid,˵��[start,mid]һ���ǵ�������
        if (nums[start] <= nums[mid]) {
            //���Ŀ��ֵ����startС��mid����һ����ͷ���ĵ���������
            if (target >= nums[start] && target <= nums[mid]) {
                return find(nums, start, mid, target);
            } else {
                return find(nums, mid + 1, end, target);
            }
        } else {
            //���start>mid��˵����midһ���ں�����Ǹ��������У���(mid,end]����
            //���Ŀ��ֵ��������䣬��ô����mid+1���������Ӱ�����ǰ������
            if (target > nums[mid] && target <= nums[end]) {
                return find(nums, mid + 1, end, target);
            } else {
                return find(nums, start, mid, target);
            }
        }
    }

}
