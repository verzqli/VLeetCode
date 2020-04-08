package com.young.offer;

import java.util.ArrayList;
import java.util.List;

public class Example25 {
    private List<List<Integer>> routeList;

    public static void main(String[] args) {

    }

    public List<List<Integer>> solve(TreeNode node, int sum) {
        routeList = new ArrayList<>();
        findPath(node, sum, new ArrayList<Integer>());
        return routeList;
    }

    private void findPath(TreeNode node, int sum, List<Integer> route) {
        if (node == null) {
            return;
        }
        route.add(node.value);
        sum -= node.value;
        if (sum == 0 && node.left == null && node.right == null) {
            routeList.add(new ArrayList<>(route));
        } else {
            //注意这里的节点和和是可以为负数的，所以这里就没加sum>0的判断，如果题目说明了
            //节点为正数时就可以加判断
            findPath(node.left, sum, route);
            findPath(node.right, sum, route);
        }
        route.remove(route.size() - 1);

    }

}
