package me.verzqli.leetcode.everyday;

/**
 * 209. ������С��������
 * ����һ������ n ���������������һ�������� s ���ҳ���������������� �� s �ĳ�����С�����������飬�������䳤�ȡ���������ڷ������������������飬���� 0��
 *
 * ʾ��:
 *
 * ����: s = 7, nums = [2,3,1,2,4,3]
 * ���: 2
 * ����: ������ [4,3] �Ǹ������µĳ�����С�����������顣
 * ����:
 *
 * ������Ѿ������O(n) ʱ�临�ӶȵĽⷨ, �볢�� O(n log n) ʱ�临�ӶȵĽⷨ��
 */
class LeetCode20200628 {
    public static void main(String[] args) {
        new LeetCode20200628().minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3});
    }

    public int minSubArrayLen(int s, int[] nums) {

        if (nums.length <= 0) {
            return 0;
        }
        if (s == 1) {
            return 1;
        }
        int left = 0;
        int sum = 0;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; ) {
            sum += nums[i];
            while (sum >= s) {
                sum -= nums[left++];
            }
            res = Math.min(res, i - left+2);
            i++;
        }
        if (res == Integer.MAX_VALUE) {
            return 0;
        }
        return res;
    }
}