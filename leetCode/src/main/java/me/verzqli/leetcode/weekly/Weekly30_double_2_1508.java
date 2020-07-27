package me.verzqli.leetcode.weekly;

/**
 * 给你一个数组?nums?，它包含?n?个正整数。你需要计算所有非空连续子数组的和，并将它们按升序排序，得到一个新的包含?n * (n + 1) / 2?个数字的数组。
 * <p>
 * 请你返回在新数组中下标为?left?到?right （下标从 1 开始）的所有数字和（包括左右端点）。由于答案可能很大，请你将它对 10^9 + 7 取模后返回。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,4], n = 4, left = 1, right = 5
 * 输出：13
 * 解释：所有的子数组和为 1, 3, 6, 10, 2, 5, 9, 3, 7, 4 。将它们升序排序后，我们得到新的数组 [1, 2, 3, 3, 4, 5, 6, 7, 9, 10] 。下标从 le = 1 到 ri = 5 的和为 1 + 2 + 3 + 3 + 4 = 13 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,4], n = 4, left = 3, right = 4
 * 输出：6
 * 解释：给定数组与示例 1 一样，所以新数组为 [1, 2, 3, 3, 4, 5, 6, 7, 9, 10] 。下标从 le = 3 到 ri = 4 的和为 3 + 3 = 6 。
 * 示例 3：
 * <p>
 * 输入：nums = [1,2,3,4], n = 4, left = 1, right = 10
 * 输出：50
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/range-sum-of-sorted-subarray-sums
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Weekly30_double_2_1508 {
    public static void main(String[] args) {
        new Weekly30_double_2_1508().rangeSum(new int[]{}, 1, 1, 1);
    }

    public long[] s;
    public long[] ss;
    public int n = 0;

    public int rangeSum(int[] nums, int n, int left, int right) {
        this.n = n;
        s = new long[n + 1];
        ss = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            s[i] = s[i - 1] + nums[i - 1];
            ss[i] = ss[i - 1] + s[i];
        }
        System.out.printf("F(right)"+F(right));
        return (int) ((F(right) - F(left - 1)) % 1000000007);
    }

    private long F(int side) {
        long l = 0;
        long r = ss[n];
        while (l < r) {
            long mid = (l + r) / 2;
            long[] t = get(mid);
            if (t[0] >= side) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        long[] res = get(r);
        return res[1] - (res[0] - side) * r;

    }

    long[] get(long mid) {
        int count = 0;
        long sum = 0;
        for (int end = 1, start = 0; end <= n; end++) {
            while (s[end] - s[start] > mid) {
                start++;
            }
            if (start < end) {
                count += end - start;
                sum += s[end] * (end - start) - ss[end - 1];
                if (start != 0) {
                    sum += ss[start - 1];
                }
            }
        }
        return new long[]{count, sum};
    }
}
