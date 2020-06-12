package me.verzqli.leetcode.everyday;

class LeetCode20200609 {
    public static void main(String[] args) {
    }

    public int translateNum(int num) {
        if (num == 0) {
            return 1;
        }
        char[] array = String.valueOf(num).toCharArray();
        int[] dp = new int[array.length];
        //因为这里char下标是从0开始，所以dp[0]表示的是一个字符的时候
        dp[0] = 1;
        for (int i = 1, length = array.length; i < length; i++) {
            if ((array[i - 1] - '0' == 1) || ((array[i - 1] - '0' == 2) && (array[i] - '0' <= 5))) {
                if (i-2<0){
                    dp[i] = dp[i - 1] + dp[0];
                }else{
                    dp[i] = dp[i - 1] + dp[i-2];
                }
            }else{
                dp[i]=dp[i-1];
            }
        }
        return dp[array.length-1];
    }
}
