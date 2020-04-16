package me.verzqli.leetcode.everyday;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给出一个区间的集合，请合并所有重叠的区间。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 * <p>
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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
