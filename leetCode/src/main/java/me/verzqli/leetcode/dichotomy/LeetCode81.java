package me.verzqli.leetcode.dichotomy;

/**
 * ���谴�����������������Ԥ��δ֪��ĳ�����Ͻ�������ת��
 * <p>
 * ( ���磬����?[0,0,1,2,2,5,6]?���ܱ�Ϊ?[2,5,6,0,0,1,2]?)��
 * <p>
 * ��дһ���������жϸ�����Ŀ��ֵ�Ƿ�����������С������ڷ���?true�����򷵻�?false��
 * <p>
 * ʾ��?1:
 * <p>
 * ����: nums = [2,5,6,0,0,1,2], target = 0
 * ���: true
 * ʾ��?2:
 * <p>
 * ����: nums = [2,5,6,0,0,1,2], target = 3
 * ���: false
 * ����:
 * <p>
 * ���� ������ת��������?��������Ŀ�������е�?nums? ���ܰ����ظ�Ԫ�ء�
 * ���Ӱ�쵽�����ʱ�临�Ӷ��𣿻���������Ӱ�죬Ϊʲô��
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class LeetCode81 {
    public static void main(String[] args) {
    }

    public boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (left <= right) {
            //˳��д�ϣ����Ƿ�ֹleft��right����������int���Ƶ�д����
            //����һ��С���Ż��������ò��ϣ�д������¼�¶���
            //mid = left + (right - left) / 2;
            mid = (left + right) / 2;
            if (nums[left]<=nums[mid]){

            }
        }
        return false;
    }

}
