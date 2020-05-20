package me.verzqli.leetcode.everyday;

public class LeetCode20200519 {
    public static void main(String[] args) {
        new LeetCode20200519().validPalindrome("atbbga");
    }

    public boolean validPalindrome(String s) {

        return findChar(s, 0, s.length() - 1, 1);
    }

    private boolean findChar(String s, int left, int right, int wrongCount) {
        if (left >= right) {
            return true;
        }
        if (s.charAt(left) == s.charAt(right)) {
            return   findChar(s, left+1, right-1, wrongCount);
        } else {
            if (wrongCount == 0) {
                return false;
            }

            boolean deleteLeft = findChar(s, left+1, right, 0);
            if (!deleteLeft) {
                deleteLeft = findChar(s, left, right-1, 0);
            }
            return deleteLeft;
        }
    }

}
