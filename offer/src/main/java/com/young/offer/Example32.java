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
     * �ݹ�
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
            // ���λ��1����1234, ��ʱpow = 1000,��ô��������������ֹ��ɣ�
            // (1) dfs(pow - 1)����[0,999]��1�ĸ���;
            // (2) dfs(last)����234��1���ֵĸ���;
            // (3) last+1����̶���λ1�ж����������
            return DFS(maxPow - 1) + DFS(last) + last + 1;
        } else {
            // ���λ��Ϊ1����2234����ô���Ҳ�ֳ����������ֹ��ɣ�
            // (1) pow����̶���λ1���ж��������;
            // (2) high * dfs(pow - 1)����999���ں�1999���ڵ���λ1���ֵĸ���;
            // (3) dfs(last)ͬ�ϡ�
            return maxPow + maxDigit * DFS(maxPow - 1) + DFS(last);
        }
    }
}
