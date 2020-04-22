package com.young.offer;

public class Example32 {
    public static void main(String[] args) {
        System.out.printf("ss" + (new Example32().countDigitOne2(13)));
    }

    public int countDigitOne(int n) {
        int countr = 0;
        for (int i = 1; i <= n; i *= 10) {
            int divider = i * 10;
            int a = (n / divider) * i;
            int b = Math.min(Math.max(n % divider - i + 1, 0), i);
            countr += a + b;
        }
        return countr;
    }

    /**
     * 递归
     *
     * @param n
     * @return
     */
    public int countDigitOne2(int n) {

        return DFS(n);
    }

    private int DFS(int n) {
        if (n <= 0) {
            return 0;
        }
        String nStr = String.valueOf(n);
        int maxDigit = nStr.charAt(0) - '0';
        int maxPow = (int) Math.pow(10, nStr.length() - 1);
        int last = n - maxDigit * maxPow;
        if (maxDigit == 1) {
            // 最高位是1，如1234, 此时pow = 1000,那么结果由以下三部分构成：
            // (1) dfs(pow - 1)代表[0,999]中1的个数;
            // (2) dfs(last)代表234中1出现的个数;
            // (3) last+1代表固定高位1有多少种情况。
            return DFS(maxPow - 1) + DFS(last) + last + 1;
        } else {
            // 最高位不为1，如2234，那么结果也分成以下三部分构成：
            // (1) pow代表固定高位1，有多少种情况;
            // (2) high * dfs(pow - 1)代表999以内和1999以内低三位1出现的个数;
            // (3) dfs(last)同上。
            return maxPow + maxDigit * DFS(maxPow - 1) + DFS(last);
        }
    }
}
