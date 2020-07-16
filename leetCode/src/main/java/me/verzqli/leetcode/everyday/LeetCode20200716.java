package me.verzqli.leetcode.everyday;

import java.util.ArrayDeque;
import java.util.Deque;

class LeetCode20200716 {
    public boolean isBipartite(int[][] graph) {
        int len = graph.length;
        int[] visit = new int[len];
        int RED = 1;
        int BLUE = -1;
        int NONE = 0;
        for (int i = 0; i < len; i++) {
            if (visit[i] != NONE) {
                continue;
            }
            Deque<Integer> deque = new ArrayDeque<>();
            deque.add(i);
            visit[i] = RED;
            while (!deque.isEmpty()) {
                int index = deque.pollFirst();
                int neighColor = visit[index] == RED ? BLUE : RED;
                for (int j = 0; j < graph[index].length; j++) {
                    int neigh = graph[index][j];
                    if (visit[neigh] == NONE) {
                        visit[neigh] = neighColor;
                        deque.add(neigh);
                    } else if (visit[neigh] != neighColor) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
