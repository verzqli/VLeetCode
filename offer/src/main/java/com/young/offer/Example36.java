package com.young.offer;

public class Example36 {
    public static void main(String[] args) {
    }

    public int reversePairs(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        int[] temp = new int[nums.length];

        return merge(nums, 0, nums.length - 1, temp);

    }

    private int merge(int[] nums, int start, int end, int[] temp) {
        if (start == end) {
            return 0;
        }
        int mid = (start + end) / 2;
        int leftCount = merge(nums, start, mid, temp);
        int rightCount = merge(nums, mid + 1, end, temp);
        //������һ���Ż��㣬������������ֵС�����������Сֵʱ����������֮�䲻��������ԣ�����ֱ����ӷ��ؼ���
        if (nums[mid] <= nums[mid + 1]) {
            return leftCount + rightCount;
        }
        int midCount = count(nums, start, mid, end, temp);
        return leftCount + rightCount + midCount;
    }

    private int count(int[] nums, int start, int mid, int end, int[] temp) {
        for (int i = start; i <= end; i++) {
            temp[i] = nums[i];
        }
        int left = start;
        int right = mid + 1;
        int count = 0;
        for (int i = start; i <= end; i++) {
            //��������������ֱ�Ӱ�����������ֵ����ϼ���
            if (left == mid + 1) {
                nums[i] = temp[right];
                right++;
                //��������������ֱ�Ӱ�����������ֵ����ϼ���
            } else if (right == end + 1) {
                nums[i] = temp[left];
                left++;
            } else if (temp[left] <= nums[right]) {
                nums[i] =temp[left];
                left++;
            } else {
                nums[i] =temp[right];
                right++;
                count += (mid + 1 - left);
            }

        }
        return count;

    }


}
