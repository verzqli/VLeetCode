package me.verzqli.leetcode.everyday;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author verzqli
 * @date 2020/6/25
 * @Desc
 */
class LeetCode20200625 {

    int maxLength = 0;
    int minLength = 0;

    public boolean wordBreakDp(String s, List<String> wordDict) {
        boolean dp[] = new boolean[s.length()+1];
        dp[0] = true;
        Set<String> set = new HashSet<>();

        for (int i = 0; i < wordDict.size(); i++) {
            String a = wordDict.get(i);
            maxLength = Math.max(maxLength, a.length());
            minLength = Math.min(minLength, a.length());
            set.add(wordDict.get(i));
        }
        for (int end = minLength; end <= s.length(); end++) {
            //这里的循环的起点和终点写的真好
            for (int start = Math.max(0,end-maxLength); start <= end-minLength; start++) {
                if (dp[start]&&set.contains(s.substring(start,end))){
                    dp[end] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Map<String, Integer> map = new HashMap<>();
        int dp[] = new int[s.length()];
        Arrays.fill(dp, -1);
        for (int i = 0; i < wordDict.size(); i++) {
            maxLength = Math.max(maxLength, wordDict.get(i).length());
            minLength = Math.min(minLength, wordDict.get(i).length());
            map.put(wordDict.get(i), 1);
        }

        return searchStr(s, map, dp, 0);
    }

    private boolean searchStr(String s, Map<String, Integer> map, int[] dp, int startIndex) {
        if (startIndex == s.length()) {
            return true;
        }
        if (dp[startIndex] != -1) {
            return dp[startIndex] == 1;
        }

        for (int i = startIndex + 1, length = Math.min(startIndex + maxLength, s.length()); i <= length; i++) {
            if (i - startIndex < minLength) {
                continue;
            }
            if (map.containsKey(s.substring(startIndex, i))) {
                if (searchStr(s, map, dp, i)) {
                    dp[startIndex] = 1;
                    return true;
                }
            }
        }
        dp[startIndex] = 0;
        return false;
    }
}
