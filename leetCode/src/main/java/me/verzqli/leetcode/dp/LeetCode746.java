package me.verzqli.leetcode.dp;

public class LeetCode746 {
    public static void main(String[] args) {

    }

    public int minCostClimbingStairs(int[] cost) {
//        int[] dp = new int[cost.length];

        int cur = 0;
        int last1=0;
        int last2=0;
        for(int i = 2;i<cost.length;i++){
//            if(i==cost.length-1){
//                dp[i]=Math.min(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2]+cost[i]);
//            }else{
//                dp[i]=Math.min(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2]);
//            }
            if (i==cost.length-1){
                cur  = Math.min( last1+cost[i-1],last2+cost[i-2]+cost[i]);
            }else{
                cur  = Math.min( last1+cost[i-1],last2+cost[i-2]);
                last2=last1;
                last1=cur;
            }
        }
        return cur;
    }

}
