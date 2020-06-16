package me.verzqli.leetcode.everyday;

/**
 * @author verzqli
 * @date 2020/6/14
 * @Desc
 */

import java.util.Arrays;

/**
 * 1300. 转变数组后最接近目标值的数组和
 * <p>
 * 给你一个整数数组?arr 和一个目标值?target ，请你返回一个整数?value?，使得将数组中所有大于?value 的值变成?value 后，数组的和最接近? target?（最接近表示两者之差的绝对值最小）。
 * <p>
 * 如果有多种使得和最接近?target?的方案，请你返回这些整数中的最小值。
 * <p>
 * 请注意，答案不一定是?arr 中的数字。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [4,9,3], target = 10
 * 输出：3
 * 解释：当选择 value 为 3 时，数组会变成 [3, 3, 3]，和为 9 ，这是最接近 target 的方案。
 * 示例 2：
 * <p>
 * 输入：arr = [2,3,5], target = 10
 * 输出：5
 * 示例 3：
 * <p>
 * 输入：arr = [60864,25176,27249,21296,20204], target = 56803
 * 输出：11361
 * ?
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 10^4
 * 1 <= arr[i], target <= 10^5
 */
public class LeetCode20200614 {
    public static void main(String[] args) {
        new LeetCode20200614().findBestValue(new int[]{3, 4, 5, 6}, 18);

    }


    public int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            if (arr[i] * (len - i) == target) {
                return arr[i];
            } else if (arr[i] * (len - i) > target) {
                int average = target / (len - i);
                return (target - average * (len - i)) > ((average + 1) * (len - i) - target) ? average + 1 : average;
            } else {
                target -= arr[i];
            }
        }
        return arr[len-1];
    }
}
