package com.young.offer;

public class Example34 {
    public static void main(String[] args) {
    }

    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0]=1;
        int l2=0,l3=0,l5=0;
        for (int i = 1; i < n; i++) {
            dp[i] = Math.min(Math.min(dp[l2]*2,dp[l3]*3),dp[l5]*5);
            if (dp[i]%2==0){
                l2++;
            }
            if (dp[i]%3==0){
                l3++;
            }
            if (dp[i]%5==0){
                l5++;
            }
        }
        return dp[n-1];
    }

}
