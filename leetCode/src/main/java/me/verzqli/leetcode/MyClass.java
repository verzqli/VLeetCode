package me.verzqli.leetcode;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class MyClass {
    public static void main(String[] args) {
    }

    public int calculateMinimumHP(int[][] dungeon) {
        int row = dungeon.length;
        int col = dungeon[0].length;
        int dp[][] = new int[row][col];
        dp[row - 1][col - 1] = Math.min(dungeon[row - 1][col - 1], 0);
        for (int i = col - 2; i >= 0; i--) {
            //通俗易懂的写法，可以转换成下面这种写法。
            int a = dungeon[row - 1][i] + dp[row - 1][i + 1];
            if (a > 0) {
                dp[row - 1][i] = 0;
            } else {
                dp[row - 1][i] = a;
            }
        }
        for (int i = row - 2; i >= 0; i--) {
            dp[i][col - 1] = Math.min(dungeon[i][col-1]+dp[i+1][col-1],0);
        }
        for (int i = row - 2; i >= 0; i--) {
            for (int j = col - 2; j >= 0; j--) {
                //这里最开始里面的max写成了min
                // 因为右边和下边的dp值要不为0，要不小于0，我们要求的最小生命值应该是取最大值
                dp[i][j] = Math.min(Math.max(dp[i][j + 1], dp[i + 1][j])+dungeon[i][j], 0);

            }
        }
        return  dp[0][0]>0?1:-dp[0][0]+1;
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

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        ArrayList<double[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            graph[edges[i][0]].add(new double[] { edges[i][1], succProb[i] });
            graph[edges[i][1]].add(new double[] { edges[i][0], succProb[i] });
        }
        PriorityQueue<double[]> queue = new PriorityQueue<>((a, b) -> Double.compare(b[1], a[1]));
        boolean[] visited = new boolean[n];
        queue.add(new double[] { start, 1 });
        while (!queue.isEmpty()) {
            double[] head = queue.remove();
            if (head[0] == end) {
                return head[1];
            } else if (!visited[(int) head[0]]) {
                visited[(int) head[0]] = true;
                for (double[] next : graph[(int) head[0]]) {
                    queue.add(new double[] { next[0], head[1] * next[1] });
                }
            }
        }
        return 0;
    }

    public class Edge {

    }
}