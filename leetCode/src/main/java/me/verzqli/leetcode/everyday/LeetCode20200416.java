package me.verzqli.leetcode.everyday;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ����һ������ļ��ϣ���ϲ������ص������䡣
 * <p>
 * ʾ�� 1:
 * <p>
 * ����: [[1,3],[2,6],[8,10],[15,18]]
 * ���: [[1,6],[8,10],[15,18]]
 * ����: ���� [1,3] �� [2,6] �ص�, �����Ǻϲ�Ϊ [1,6].
 * ʾ��?2:
 * <p>
 * ����: [[1,4],[4,5]]
 * ���: [[1,5]]
 * ����: ���� [1,4] �� [4,5] �ɱ���Ϊ�ص����䡣
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/merge-intervals
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class LeetCode20200416 {
    public static void main(String[] args) {
        new LeetCode20200416().merge(new int[][]{{1, 3}, {4, 6}, {5, 7}});
    }

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        int start = intervals[0][0], end = intervals[0][1];
        List<int[]> result = new ArrayList<>();
        for (int i = 1, length = intervals.length; i < length; i++) {
            int point1 = intervals[i][0];
            int point2 = intervals[i][1];
            if (end < point1) {
                result.add(new int[]{start, end});
                start = point1;
                end = point2;

            } else {
                if (start > point1) {
                    start = point1;
                }
                if (end < point2) {
                    end = point2;
                }
            }

        }
        result.add(new int[]{start, end});
        return result.toArray(new int[result.size()][2]);
    }

}
