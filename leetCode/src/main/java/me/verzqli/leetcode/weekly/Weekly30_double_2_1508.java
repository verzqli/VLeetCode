package me.verzqli.leetcode.weekly;

/**
 * ����һ������?nums?��������?n?��������������Ҫ�������зǿ�����������ĺͣ��������ǰ��������򣬵õ�һ���µİ���?n * (n + 1) / 2?�����ֵ����顣
 * <p>
 * ���㷵�������������±�Ϊ?left?��?right ���±�� 1 ��ʼ�����������ֺͣ��������Ҷ˵㣩�����ڴ𰸿��ܴܺ����㽫���� 10^9 + 7 ȡģ�󷵻ء�
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺nums = [1,2,3,4], n = 4, left = 1, right = 5
 * �����13
 * ���ͣ����е��������Ϊ 1, 3, 6, 10, 2, 5, 9, 3, 7, 4 ��������������������ǵõ��µ����� [1, 2, 3, 3, 4, 5, 6, 7, 9, 10] ���±�� le = 1 �� ri = 5 �ĺ�Ϊ 1 + 2 + 3 + 3 + 4 = 13 ��
 * ʾ�� 2��
 * <p>
 * ���룺nums = [1,2,3,4], n = 4, left = 3, right = 4
 * �����6
 * ���ͣ�����������ʾ�� 1 һ��������������Ϊ [1, 2, 3, 3, 4, 5, 6, 7, 9, 10] ���±�� le = 3 �� ri = 4 �ĺ�Ϊ 3 + 3 = 6 ��
 * ʾ�� 3��
 * <p>
 * ���룺nums = [1,2,3,4], n = 4, left = 1, right = 10
 * �����50
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/range-sum-of-sorted-subarray-sums
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
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
