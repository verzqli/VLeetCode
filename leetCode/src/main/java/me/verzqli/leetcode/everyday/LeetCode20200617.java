package me.verzqli.leetcode.everyday;

class LeetCode20200617 {

    public int maxScoreSightseeingPair(int[] A) {
        int result = 0;
        int maxI = A[0];
        for (int i = 1; i < A.length; i++) {
            result = Math.max(result, maxI + A[i] - i);
            maxI = Math.max(maxI, A[i] + i);
        }
        return result;
    }
}
