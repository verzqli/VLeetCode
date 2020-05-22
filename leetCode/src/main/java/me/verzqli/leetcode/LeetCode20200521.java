package me.verzqli.leetcode;

/**
 * 5. 最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 */
public class LeetCode20200521 {
    public static void main(String[] args) {
    }

    /**
     * 中心扩散方法
     * @param s
     * @return
     */
    public String longestPalindromeCenter(String s) {
        if (s.length()<=1){
            return s;
        }
        int length = s.length();
        int maxLength =1;
        int begin = 0;
        //因为到了最后一个子串就无法向右边再扩展回文子串了，所以遍历到倒数第二个。
        for (int i = 0; i < length-1; i++) {
            //获得奇数中心的长度
            int length1 = getEvenOddLength(s,i,i);
            //获得偶数中心的长度，因为偶数中心是两个对称，并不像奇数那样有个中间字符对称
            int length2 = getEvenOddLength(s,i,i+1);
            int subMaxLength = Math.max(length1,length2);
            if (subMaxLength>maxLength){
                maxLength=subMaxLength;
                //如果是偶数，则开始点则为i向前移动maxLength/2 -1步
                //如果是奇数，则开始点则为i向前移动maxLength/2 步
                begin = i-(maxLength-1)/2;
            }

        }

        return s.substring(begin,begin+maxLength);
    }

    private int getEvenOddLength(String s, int left, int right) {
        int length = s.length();
        while (left>=0&&right<s.length()){
            if (s.charAt(left)==s.charAt(right)){
                left--;
                right++;
            }else{
                break;
            }
        }
        //这里注意不是right-left+1，因为right和left这两个下标是不符合要求的 所以长度应该为
        //right-1-(left+1)+1=right-left-1
        return right-left-1;
    }

    /**
     * 动态规划
     * @param s
     * @return
     */
    public String longestPalindromeDp(String s) {
        if (s.length()<=1){
            return s;
        }
        int length = s.length();
        boolean[][] dp = new boolean[length][length];
        //注意这里是1，因为最短的回文子串就是一个字符，所以必然存在一个最短的回文子串
        int maxLength =1;
        int begin = 0;
        for (int end = 1; end < length; end++) {
            for (int start = 0; start < end; start++) {
                if (s.charAt(start)!=s.charAt(end)){
                    dp[start][end]=false;
                }else{
                    if (end-start<=2){
                        dp[start][end]=true;
                    }else{
                        dp[start][end] =  dp[start+1][end-1];
                    }
                }
                if (dp[start][end]&&end-start+1>maxLength){
                    maxLength = end-start+1;
                    begin = start;
                }
            }
        }


        return s.substring(begin,begin+maxLength);
    }

}
