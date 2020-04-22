package me.verzqli.leetcode.everyday;

/**
 * ����һ����������?nums ��һ������ k��
 *
 * ���ĳ�� ���� ��������ǡ���� k ���������֣����Ǿ���Ϊ����������ǡ����������项��
 *
 * �뷵����������С����������项����Ŀ��
 *
 * ?ʾ�� 1��
 *
 * ���룺nums = [1,1,2,1,1], k = 3
 * �����2
 * ���ͣ����� 3 ���������������� [1,1,2,1] �� [1,2,1,1] ��
 * ʾ�� 2��
 *
 * ���룺nums = [2,4,6], k = 1
 * �����0
 * ���ͣ������в������κ����������Բ��������������顣
 * ʾ�� 3��
 *
 * ���룺nums = [2,2,2,1,2,2,1,2,2,2], k = 2
 * �����16
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/count-number-of-nice-subarrays
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class LeetCode20200421 {
    public static void main(String[] args) {
        System.out.printf("aaaa" + (new LeetCode20200421().numberOfSubarrays(new int[]{1, 1, 1, 1, 1}, 1)));
    }

    public int numberOfSubarrays(int[] nums, int k) {

        int length = nums.length;
        int[] array = new int[length + 2];
        int count = 0;
        int result=0;
        for (int i = 0; i < length; i++) {
            if ((nums[i] & 1) == 1) {
                array[++count] = i;
            }
        }
        array[0] = -1;
        array[++count] = length;
        for (int i = 1; i+k <= count; i++) {
            result+=(array[i]-array[i-1])*(array[i+k]-array[i+k-1]);
        }
        return result;
    }
}
