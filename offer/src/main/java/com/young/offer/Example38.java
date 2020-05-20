package com.young.offer;

/**
 * ������53 - I. �����������в������� I
 * ͳ��һ�����������������г��ֵĴ�����
 * <p>
 * <p>
 * <p>
 * ʾ�� 1:
 * <p>
 * ����: nums = [5,7,7,8,8,10], target = 8
 * ���: 2
 * ʾ�� 2:
 * <p>
 * ����: nums = [5,7,7,8,8,10], target = 6
 * ���: 0
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
            //���뵽���ڲ�ͬ������ж�ǰһ�����ߺ�һ�����ж����Ƿ���Ҫ����±꣬
            //�����ж��Ƿ������߽��������б߽�����û�뵽��
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
