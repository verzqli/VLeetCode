package me.verzqli.leetcode.everyday;

/**
 * ʵ��?pow(x, n)?�������� x �� n ���ݺ�����
 * <p>
 * ʾ�� 1:
 * <p>
 * ����: 2.00000, 10
 * ���: 1024.00000
 * ʾ��?2:
 * <p>
 * ����: 2.10000, 3
 * ���: 9.26100
 * ʾ��?3:
 * <p>
 * ����: 2.00000, -2
 * ���: 0.25000
 * ����: 2-2 = 1/22 = 1/4 = 0.25
 * ˵��:
 * <p>
 * -100.0 <?x?< 100.0
 * n?�� 32 λ�з�������������ֵ��Χ��?[?2^31,?2^31?? 1] ��
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/powx-n
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class LeetCode20200511 {
    public static void main(String[] args) {
        new LeetCode20200511().myPow2(2.00000, -2147483648);
    }

    public double quickMul(double x, long N) {
        if (N == 0) {
            return 1.0;
        }
        double y = quickMul(x, N / 2);
        return N % 2 == 0 ? y * y : y * y * x;
    }

    public double myPow(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }

    public double myPow2(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double result = 1d;
        double temp = x;
        //abs��Χ��int
//        long absN = Math.abs(n);
        // ��Ϊint��Χ��[?2^31, 2^31 ? 1],�������ﲻ��ֱ���ø��ţ�����Ҫ��ת����long
//        long absN = n < 0 ? -n : n;
        long N = n;
        long absN = N < 0 ? -N : N;
        while (absN > 0) {
            //�ж����һ���Ƿ�Ϊ1
            if (absN % 2 == 1) {
                result *= temp;
            }
            //ÿ��һλ�������ݼ�һ����β����Ϊ1ʱ�������ֵ
            temp *= temp;
            //����һ�κ�����һ�Σ������������������е�1.
            absN = absN / 2;
        }
        return n < 0 ? 1 / result : result;
    }
}
