package me.verzqli.leetcode.everyday;

/**
 * ����һ���Ǹ��������飬�����λ������ĵ�һ��λ�á�
 *
 * �����е�ÿ��Ԫ�ش������ڸ�λ�ÿ�����Ծ����󳤶ȡ�
 *
 * �ж����Ƿ��ܹ��������һ��λ�á�
 *
 * ʾ��?1:
 *
 * ����: [2,3,1,1,4]
 * ���: true
 * ����: ���ǿ������� 1 ������λ�� 0 ���� λ�� 1, Ȼ���ٴ�λ�� 1 �� 3 ���������һ��λ�á�
 * ʾ��?2:
 *
 * ����: [3,2,1,0,4]
 * ���: false
 * ����: �������������ܻᵽ������Ϊ 3 ��λ�á�����λ�õ������Ծ������ 0 �� ��������Զ�����ܵ������һ��λ�á�
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/jump-game
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class LeetCode20200417 {
    public static void main(String[] args) {
        new LeetCode20200417().canJump(new int[]{0, 2, 3});
    }

    public boolean canJump(int[] nums) {
        if (nums.length <= 1) {
            return true;
        }
        if (nums[0] ==0) {
            return false;
        }
        int index = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= index) {
                index = i;
            } else {
                if (i == 0) {
                    return false;
                }
            }
        }
        return index != (nums.length - 1);
    }

}
