package me.verzqli.leetcode.prefix;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. ����֮��
 * ����һ���������� nums ��һ��Ŀ��ֵ target�������ڸ��������ҳ���ΪĿ��ֵ���� ���� ���������������ǵ������±ꡣ
 * <p>
 * ����Լ���ÿ������ֻ���Ӧһ���𰸡����ǣ�������ͬһ��Ԫ�ز���ʹ�����顣
 * <p>
 * ʾ��:
 * <p>
 * ���� nums = [2, 7, 11, 15], target = 9
 * <p>
 * ��Ϊ nums[0] + nums[1] = 2 + 7 = 9
 * ���Է��� [0, 1]
 */
class LeetCode001 {
    public static void main(String[] args) {
    }

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        if (nums.length < 1) {
            return result;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = map.getOrDefault(target - nums[i], 0);
            if (temp != 0) {
                result[0] = temp-1;
                result[1] = i;
                break;
            } else {
                map.put(nums[i], i+1);
            }
        }
        return result;
    }

}
