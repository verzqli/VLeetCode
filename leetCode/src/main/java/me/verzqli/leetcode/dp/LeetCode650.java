package me.verzqli.leetcode.dp;

public class LeetCode650 {
    public static void main(String[] args) {
        new LeetCode650().minSteps(14);
    }

    public int minSteps(int n) {
        int dp[] = new int[n+1];
        int half = n/2;
        for(int i=2;i<=n;i++){
            dp[i] = i;
            for (int j = 2; j <= half; j++) {
                if (i%j==0){
                    dp[i]=dp[j]+dp[i/j];
                    break;
                }
            }
        }
        return dp[n];
    }

}
