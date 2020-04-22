package com.young.offer;

/**
 * ����һ���������� nums ���ҵ�һ���������͵����������飨���������ٰ���һ��Ԫ�أ������������͡�
 *
 * ����: [-2,1,-3,4,-1,2,1,-5,4],
 * ���: 6
 * ����: ���������� [4,-1,2,1] �ĺ����Ϊ 6��
 */
public class Example31 {
    public static void main(String[] args) {
    }

    /**
     * ̰���㷨��ÿһ�μ��㶼ѡ������ֵ
     * ÿ����ǰ������֮�ͼ��ϵ�ǰ���֣�����ʹ��ڵ�ǰ���֣���ô�ͷ��������ֵ��Ȼ�����
     * ���С�ڵ�ǰ���֣�˵��ǰ���Ǹ���������������Щ���֣��ӵ�ǰ���ּ�����ʼ�ӡ�
     */
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int resultMax = nums[0];
        int curMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            curMax = Math.max(nums[i], curMax + nums[i]);
            resultMax = Math.max(curMax, resultMax);
        }
        return resultMax;
    }

    /**
     * ��̬�滮
     * ����Ķ�̬�滮������̰���㷨��ʵ��ֻ࣬����̰��ʡȥ�˶�̬�滮�����飬����һ��curMax������
     */
    public int maxSubArray2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int resultMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] < 0) {
                dp[i] = nums[i];
            } else {
                dp[i] = dp[i - 1] + nums[i];
            }
            resultMax = Math.max(resultMax, dp[i]);
        }
        return resultMax;
    }

}
