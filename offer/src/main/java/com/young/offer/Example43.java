package com.young.offer;

/**
 * ������60. n�����ӵĵ���
 * ��n���������ڵ��ϣ��������ӳ���һ��ĵ���֮��Ϊs������n����ӡ��s�����п��ܵ�ֵ���ֵĸ��ʡ�
 * <p>
 * ����Ҫ��һ�����������鷵�ش𰸣����е� i ��Ԫ�ش����� n ���������������ĵ��������е� i С���Ǹ��ĸ��ʡ�
 * <p>
 * ʾ�� 1:
 * <p>
 * ����: 1
 * ���: [0.16667,0.16667,0.16667,0.16667,0.16667,0.16667]
 * ʾ�� 2:
 * <p>
 * ����: 2
 * ���: [0.02778,0.05556,0.08333,0.11111,0.13889,0.16667,0.13889,0.11111,0.08333,0.05556,0.02778]
 */
class Example43 {
    public static void main(String[] args) {
        new Example43().twoSum(3);
    }

    public double[] twoSum(int n) {
        if (n <= 1) {
            return new double[]{1 / 6d, 1 / 6d, 1 / 6d, 1 / 6d, 1 / 6d, 1 / 6d};
        }
        double[] result = new double[5*n+1];
        int dp[][] = new int[n + 1][(6 * n) + 1];
        for (int i = 1; i <= 6; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= 6 * i; j++) {
                for (int k = 1; k <=6 ; k++) {
                    //�ܵ���һ��Ҫ������������
                    if (j-k<i-1){
                        break;
                    }
                    dp[i][j] += dp[i - 1][j - k];
                }
            }
        }
        double totalCount = Math.pow(6, n);
        for (int i = n; i <= 6 * n; i++) {
            result[i - n] =dp[n][i] / totalCount;
        }
        return  result;
    }

}
