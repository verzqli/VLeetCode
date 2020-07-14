package me.verzqli.leetcode;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class MyClass {
    public static void main(String[] args) {
    }


    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int count = map.get(nums[i]);
                res += count;
                map.put(nums[i], count + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        return res;
    }

    public int numSub(String s) {
        int[] dp = new int[s.length()];
        int mod = 1000000007;
        dp[0] = Integer.parseInt(s.charAt(0) + "");
        int res = dp[0];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                if (dp[i - 1] == 0) {
                    dp[i] = 1;
                    res += 1;
                } else {
                    dp[i] = dp[i - 1] + 1;
                    res = (res + dp[i]) % mod;
                }
            }
        }
        return res;
    }

    public double maxProbability2(int n, int[][] edges, double[] succProb, int start, int end) {
        ArrayList<double[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            graph[edges[i][0]].add(new double[]{edges[i][1], succProb[i]});
            graph[edges[i][1]].add(new double[]{edges[i][0], succProb[i]});
        }
        PriorityQueue<double[]> queue = new PriorityQueue<>((a, b) -> Double.compare(b[1], a[1]));
        boolean[] visited = new boolean[n];
        queue.add(new double[]{start, 1});
        while (!queue.isEmpty()) {
            double[] head = queue.remove();
            if (head[0] == end) {
                return head[1];
            } else if (!visited[(int) head[0]]) {
                visited[(int) head[0]] = true;
                for (double[] next : graph[(int) head[0]]) {
                    queue.add(new double[]{next[0], head[1] * next[1]});
                }
            }
        }
        return 0;
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int maxRow = triangle.size();
        int[] dp = new int[maxRow+1];
        for (int i = maxRow-1; i >=0; i--) {
            for (int j = 0; j <=i ; j++) {
                dp[j] = Math.min(dp[j],dp[j+1])+triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
}