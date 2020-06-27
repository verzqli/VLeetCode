package me.verzqli.leetcode;


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MyClass {
    public static void main(String[] args) {
        new MyClass().longestSubarray(new int[]{1,0,0,0,0});
    }

    public double average(int[] salary) {
        int max = 0;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < salary.length; i++) {
            min = Math.min(min, salary[i]);
            max = Math.max(max, salary[i]);
            sum += salary[i];
        }
        return (sum - min - max) * 1d / (salary.length - 2);
    }

    public int kthFactor(int n, int k) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                count++;
                if (count == k) {
                    return i;
                }
            }
        }
        return -1;
    }

    public int longestSubarray(int[] nums) {
        int start = -1;
        int end = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                start = i;
                break;
            }
        }
        if (start == -1) {
            return 0;
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == 1) {
                end = i;
                break;
            }
        }
        if (start==end){
            if (nums.length>1){
                return 1;
            }
        }

        int max = 0;
        int[] temp = new int[end - start + 1];
        int count_1 = 1;
        int count_0 = 0;
        int index = 0;
        int all = 1;
        for (int i = start + 1; i <= end; i++) {
            if (nums[i] == 1) {
                all++;
                if (count_1 == 0) {
                    temp[index++] = -count_0;
                    count_0 = 0;
                }
                count_1++;
                if (i==end){
                    temp[index++]=count_1;
                }
            }else{
                if (count_0 == 0) {
                    temp[index++] = count_1;
                    count_1 = 0;
                }
                count_0++;
            }
        }
        if (all==nums.length){
            return all-1;
        }
        for (int i = 0; i < index; i++) {
            if (temp[i]==-1){
                max = Math.max(max,temp[i-1]+temp[i+1]);
                i+=1;
            }
        }
        return max;
    }

}