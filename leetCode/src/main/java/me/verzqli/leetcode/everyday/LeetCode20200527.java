package me.verzqli.leetcode.everyday;

import org.omg.CORBA.MARSHAL;

import java.util.HashMap;
import java.util.Map;

public class LeetCode20200527 {
    public static void main(String[] args) {
    }

    public int subarraysDivByK(int[] A, int K) {
        int count = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            if (sum < 0) {
                //外面还要在%一次的例子：sum=-5
                sum = (sum % K + K) % K;
            } else {
                sum = sum % K;
            }
            int history = map.getOrDefault(sum, 0);
            count += history;
            map.put(sum, history + 1);
        }
        return count;
    }


}
