package me.verzqli.leetcode.everyday;

class LeetCode20200709 {
    public static void main(String[] args) {
        new LeetCode20200709().respace(new String[]{"looked", "just", "like", "her", "brother"}, "jesslookedjustliketimherbrother");
    }

    public class TrieNode {
        public TrieNode[] child;
        public boolean isEnd = false;

        public  TrieNode() {
            child = new TrieNode[26];
        }

    }
    TrieNode root;

    public int respace(String[] dictionary, String sentence) {
        makeTrieNode(dictionary);
        int len = sentence.length();
        int dp[] = new int[len + 1];
        dp[0] = 0;
        for (int i = 1; i <= len; i++) {
            dp[i] = dp[i - 1] + 1;
            TrieNode node = root;
            for (int j = i; j >= 1; j--) {
                //这里注意是j-1
                int index = sentence.charAt(j-1) - 'a';
                if (node.child[index] == null) {
                    break;
                } else {
                    node = node.child[index];
                    if (node.isEnd) {
                        dp[i] = Math.min(dp[i], dp[j - 1]);
                        if (dp[i] == 0) {
                            break;
                        }
                    }
                }
            }
        }
        return dp[len];
    }

    private void makeTrieNode(String[] dictionary) {
        root = new TrieNode();
        for (String str : dictionary) {
            TrieNode start = root;
            for (int i = str.length() - 1; i >= 0; i--) {
                int index = str.charAt(i) - 'a';
                if (start.child[index] == null) {
                    start.child[index] = new TrieNode();
                }
                start = start.child[index];
            }
            //單詞是否结尾
            start.isEnd = true;
        }
    }
}
