package me.verzqli.leetcode.everyday;

/**
 * ��һ�������к��ܻ�ӭ�Ĺ��ȣ�����ǰһ��ƻ���һЩ�����С��ڽ�������һ�����Ҫ���е����ӽ���һ����Ϊ?days?�����������
 * ÿһ����һ����?1?��?365?��������
 * <p>
 * ��Ʊ�����ֲ�ͬ�����۷�ʽ��
 * <p>
 * һ��Ϊ��һ���ͨ��֤�ۼ�Ϊ?costs[0] ��Ԫ��
 * һ��Ϊ�������ͨ��֤�ۼ�Ϊ?costs[1] ��Ԫ��
 * һ��Ϊ����ʮ���ͨ��֤�ۼ�Ϊ?costs[2] ��Ԫ��
 * ͨ��֤�������������Ƶ����С� ���磬��������ڵ� 2 ����һ��Ϊ�� 7 ���ͨ��֤��
 * ��ô���ǿ����������� 7 �죺�� 2 �졢�� 3 �졢�� 4 �졢�� 5 �졢�� 6 �졢�� 7 ��͵� 8 �졣
 * <p>
 * ��������Ҫ����ڸ������б�?days?���г���ÿһ�����������Ҫ��������ѡ�
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/minimum-cost-for-tickets
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class LeetCode20200506 {
    public static void main(String[] args) {
    }

    public int mincostTickets(int[] days, int[] costs) {
        if (days.length == 1) {
            return costs[0];
        }
        int length = days.length ;
        int startDay = days[0];
        int endDay = days[length-1];
        int index = length-1;
        int[] dp = new int[endDay+30];
        for (int i = endDay; i >= startDay; i--) {
            if (i == days[index]) {
                dp[i] = Math.min(costs[0]+dp[i+1], costs[1] + dp[i + 7]);
                dp[i] = Math.min(dp[i], costs[2] + dp[i + 30]);
               index--;
            }else{
                dp[i]=dp[i+1];
            }

        }
        return dp[startDay];
    }

}
