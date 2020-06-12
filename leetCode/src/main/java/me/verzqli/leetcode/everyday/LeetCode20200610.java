package me.verzqli.leetcode.everyday;

class LeetCode20200610 {
    public static void main(String[] args) {
    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x < 10) {
            return true;
        }
        char[] chars = String.valueOf(x).toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while (left <= right) {
            if (chars[left] == chars[right]) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * 数学方法
     *
     * @param x
     * @return
     */
    public boolean isPalindrome2(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        if (x < 10) {
            return true;
        }
        int halfReverse = 0;
        while (x > halfReverse) {
            halfReverse = halfReverse * 10 + x % 10;
            x /= 10;
        }
        return x == halfReverse || x == halfReverse / 10;
    }
}
