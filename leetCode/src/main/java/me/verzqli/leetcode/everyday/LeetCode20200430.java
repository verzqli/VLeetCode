package me.verzqli.leetcode.everyday;

public class LeetCode20200430 {
    public static void main(String[] args) {
        new LeetCode20200430().isHappy(2);
    }

    public boolean isHappy(int n) {
        int fast = count(n);
        int slow = n;

        while (fast != 1 && fast != slow) {
            fast = count(count(fast));
            slow = count(slow);
        }
        return fast==1;
    }

    private int count(int n) {
        if (n < 10) {
            return n * n;
        }
        int result = 0;
        int i = 10;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            result += d * d;
        }
        return result;

    }

}
