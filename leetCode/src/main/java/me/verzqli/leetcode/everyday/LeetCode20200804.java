package me.verzqli.leetcode.everyday;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class LeetCode20200804 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> side = new ArrayList<>();
        int[] course = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            side.add(new ArrayList<>());
        }
        for (int i = 0; i <prerequisites.length ; i++) {
            side.get(prerequisites[i][1]).add(prerequisites[i][0]);
            course[prerequisites[i][0]]++;
        }
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (course[i]==0){
                //不是添加course[i],而是课程编号i
                deque.add(i);
            }
        }

        int count = 0;
        while (!deque.isEmpty()) {
            int courseIndex = deque.pollFirst();
            for (int preIndex:side.get(courseIndex)) {
              --course[preIndex];
              if (course[preIndex]==0){
                  //这里和上面的都警惕一下，不是添加course[preIndex]
                  deque.add(preIndex);
              }
            }
            count++;
        }
        return count==numCourses;
    }

}
