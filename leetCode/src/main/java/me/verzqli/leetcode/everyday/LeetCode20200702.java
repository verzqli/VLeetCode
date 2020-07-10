package me.verzqli.leetcode.everyday;

class LeetCode20200702 {
    public int kthSmallest(int[][] matrix, int k) {
        int len = matrix.length;
        int min = matrix[0][0];
        int max = matrix[len - 1][len - 1];
        while (min < max) {
            int mid = min + (min - max) / 2;
            if (check(matrix, mid, k)) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        return min;
    }

    private boolean check(int[][] matrix, int mid, int k) {
        int len = matrix.length;
        //从左下角开始,蜿蜒向右上角爬
        int x = len - 1;
        int y = 0;
        int count = 0;
        while (x >= 0 && y < len) {
            if (matrix[x][y] <= mid) {
                count += x + 1;
                y++;
            } else {
                x--;
            }
        }
        return count >= k;
    }
}
