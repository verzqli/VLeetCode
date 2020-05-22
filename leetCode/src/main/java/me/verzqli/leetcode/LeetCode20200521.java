package me.verzqli.leetcode;

/**
 * 5. ������Ӵ�
 * ����һ���ַ��� s���ҵ� s ����Ļ����Ӵ�������Լ��� s ����󳤶�Ϊ 1000��
 *
 * ʾ�� 1��
 *
 * ����: "babad"
 * ���: "bab"
 * ע��: "aba" Ҳ��һ����Ч�𰸡�
 * ʾ�� 2��
 *
 * ����: "cbbd"
 * ���: "bb"
 */
public class LeetCode20200521 {
    public static void main(String[] args) {
    }

    /**
     * ������ɢ����
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
        //��Ϊ�������һ���Ӵ����޷����ұ�����չ�����Ӵ��ˣ����Ա����������ڶ�����
        for (int i = 0; i < length-1; i++) {
            //����������ĵĳ���
            int length1 = getEvenOddLength(s,i,i);
            //���ż�����ĵĳ��ȣ���Ϊż�������������Գƣ����������������и��м��ַ��Գ�
            int length2 = getEvenOddLength(s,i,i+1);
            int subMaxLength = Math.max(length1,length2);
            if (subMaxLength>maxLength){
                maxLength=subMaxLength;
                //�����ż������ʼ����Ϊi��ǰ�ƶ�maxLength/2 -1��
                //�������������ʼ����Ϊi��ǰ�ƶ�maxLength/2 ��
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
        //����ע�ⲻ��right-left+1����Ϊright��left�������±��ǲ�����Ҫ��� ���Գ���Ӧ��Ϊ
        //right-1-(left+1)+1=right-left-1
        return right-left-1;
    }

    /**
     * ��̬�滮
     * @param s
     * @return
     */
    public String longestPalindromeDp(String s) {
        if (s.length()<=1){
            return s;
        }
        int length = s.length();
        boolean[][] dp = new boolean[length][length];
        //ע��������1����Ϊ��̵Ļ����Ӵ�����һ���ַ������Ա�Ȼ����һ����̵Ļ����Ӵ�
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
