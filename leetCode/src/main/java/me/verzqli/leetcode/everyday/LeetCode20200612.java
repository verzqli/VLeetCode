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
            //ȥ�أ���i������һ��ֵʱ�����ߵĺ͵�����кܶ���һ����
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
                        //ȥ��,�����һ�����ʱ����Ҫstart++��end--
                        //����Ϊ��ȥ�أ���Ҫ�����ߵ���һ��ֵ���Ƿ��ظ��жϣ��ظ�������
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