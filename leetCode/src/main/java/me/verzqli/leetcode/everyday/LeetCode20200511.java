package me.verzqli.leetcode.everyday;

/**
 * 实现?pow(x, n)?，即计算 x 的 n 次幂函数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 示例?2:
 * <p>
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 示例?3:
 * <p>
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 * 说明:
 * <p>
 * -100.0 <?x?< 100.0
 * n?是 32 位有符号整数，其数值范围是?[?2^31,?2^31?? 1] 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/powx-n
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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
        //abs范围是int
//        long absN = Math.abs(n);
        // 因为int范围是[?2^31, 2^31 ? 1],所以这里不能直接用负号，而是要先转换成long
//        long absN = n < 0 ? -n : n;
        long N = n;
        long absN = N < 0 ? -N : N;
        while (absN > 0) {
            //判断最后一个是否为1
            if (absN % 2 == 1) {
                result *= temp;
            }
            //每过一位，即次幂加一，当尾进制为1时乘以这个值
            temp *= temp;
            //计算一次后，右移一次，来遍历整个二进制中的1.
            absN = absN / 2;
        }
        return n < 0 ? 1 / result : result;
    }
}
