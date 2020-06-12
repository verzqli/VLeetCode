package me.verzqli.leetcode.everyday;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class LeetCode20200612 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        int start = 1;
        int end = nums.length - 1;
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                break;
            }
            //去重，当i等于下一个值时，两者的和的组合有很多是一样的
            if (i == 0 || nums[i] != nums[i - 1]) {
                start = i + 1;
                end = nums.length - 1;
                while (start < end) {
                    int sum = nums[i] + nums[start] + nums[end];
                    if (sum > 0) {
                        end--;
                    } else if (sum < 0) {
                        start++;
                    } else {
                        List<Integer> item = new ArrayList<>();
                        item.add(nums[i]);
                        item.add(nums[start]);
                        item.add(nums[end]);
                        result.add(item);
                        //去重,当获得一个结果时，需要start++和end--
                        //但是为了去重，需要对两边的下一个值做是否重复判断，重复就跳过
                        while (start < end && nums[start] == nums[start + 1]) {
                            start++;
                        }
                        while (start < end && nums[end] == nums[end - 1]) {
                            end--;
                        }
                        start++;
                        end--;

                    }
                }
            }

        }
        return result;
    }
}