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
        //��Ϊ����char�±��Ǵ�0��ʼ������dp[0]��ʾ����һ���ַ���ʱ��
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
