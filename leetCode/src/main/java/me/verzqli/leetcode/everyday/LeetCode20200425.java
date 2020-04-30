package me.verzqli.leetcode.everyday;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode20200425 {
    List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {
        new LeetCode20200425().permute2(new int[]{1, 2, 3});
    }


    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) {
            return result;
        }
        boolean[] temp = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            temp[i] = true;
        }
        count(nums, temp, new LinkedList<>());
        return result;
    }

    private void count(int[] nums, boolean[] temp, LinkedList<Integer> path) {
        if (path.size() == nums.length) {
            result.add(new LinkedList<>(path));
            return;
        }
        for (int i = 0, length = nums.length; i < length; i++) {
            if (temp[i]) {
                path.add(nums[i]);
                temp[i] = false;
                count(nums, temp, path);
                path.removeLast();
                temp[i] = true;

            }
        }
    }

    /**
     * 不用辅助数组temp的写法
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permute2(int[] nums) {
        if (nums.length == 0) {
            return result;
        }
        List<Integer> output = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            output.add(nums[i]);
        }
        count2(output, 0);
        return result;
    }

    private void count2(List<Integer> output, int first) {
        if (first == output.size()) {
            result.add(new LinkedList<>(output));
            return;
        }
        for (int i = first, length = output.size(); i < length; i++) {
            Collections.swap(output, first, i);
            count2(output, first + 1);
            Collections.swap(output, first, i);
        }
    }
}
