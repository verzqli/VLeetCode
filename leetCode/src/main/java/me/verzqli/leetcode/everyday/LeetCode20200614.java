package me.verzqli.leetcode.everyday;

/**
 * @author verzqli
 * @date 2020/6/14
 * @Desc
 */

import java.util.Arrays;

/**
 * 1300. ת���������ӽ�Ŀ��ֵ�������
 * <p>
 * ����һ����������?arr ��һ��Ŀ��ֵ?target �����㷵��һ������?value?��ʹ�ý����������д���?value ��ֵ���?value ������ĺ���ӽ�? target?����ӽ���ʾ����֮��ľ���ֵ��С����
 * <p>
 * ����ж���ʹ�ú���ӽ�?target?�ķ��������㷵����Щ�����е���Сֵ��
 * <p>
 * ��ע�⣬�𰸲�һ����?arr �е����֡�
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺arr = [4,9,3], target = 10
 * �����3
 * ���ͣ���ѡ�� value Ϊ 3 ʱ��������� [3, 3, 3]����Ϊ 9 ��������ӽ� target �ķ�����
 * ʾ�� 2��
 * <p>
 * ���룺arr = [2,3,5], target = 10
 * �����5
 * ʾ�� 3��
 * <p>
 * ���룺arr = [60864,25176,27249,21296,20204], target = 56803
 * �����11361
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= arr.length <= 10^4
 * 1 <= arr[i], target <= 10^5
 */
public class LeetCode20200614 {
    public static void main(String[] args) {
        new LeetCode20200614().findBestValue(new int[]{3, 4, 5, 6}, 18);

    }


    public int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            if (arr[i] * (len - i) == target) {
                return arr[i];
            } else if (arr[i] * (len - i) > target) {
                int average = target / (len - i);
                return (target - average * (len - i)) > ((average + 1) * (len - i) - target) ? average + 1 : average;
            } else {
                target -= arr[i];
            }
        }
        return arr[len-1];
    }
}
