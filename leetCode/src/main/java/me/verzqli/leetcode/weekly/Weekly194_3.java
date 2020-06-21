package me.verzqli.leetcode.weekly;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author verzqli
 * @date 2020/6/21
 * @Desc 1488. 避免洪水泛滥
 * 你的国家有无数个湖泊，所有湖泊一开始都是空的。当第 n 个湖泊下雨的时候，如果第 n 个湖泊是空的，那么它就会装满水，否则这个湖泊会发生洪水。你的目标是避免任意一个湖泊发生洪水。
 * <p>
 * 给你一个整数数组 rains ，其中：
 * <p>
 * rains[i] > 0 表示第 i 天时，第 rains[i] 个湖泊会下雨。
 * rains[i] == 0 表示第 i 天没有湖泊会下雨，你可以选择 一个 湖泊并 抽干 这个湖泊的水。
 * 请返回一个数组 ans ，满足：
 * <p>
 * ans.length == rains.length
 * 如果 rains[i] > 0 ，那么ans[i] == -1 。
 * 如果 rains[i] == 0 ，ans[i] 是你第 i 天选择抽干的湖泊。
 * 如果有多种可行解，请返回它们中的 任意一个 。如果没办法阻止洪水，请返回一个 空的数组 。
 * <p>
 * 请注意，如果你选择抽干一个装满水的湖泊，它会变成一个空的湖泊。但如果你选择抽干一个空的湖泊，那么将无事发生（详情请看示例 4）。
 */
class Weekly194_3 {
    public int[] avoidFlood(int[] rains) {
        int[] r = new int[rains.length];
        //记录不下雨的日子
        LinkedList<Integer> arrayDeque = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < rains.length; i++) {
            if (rains[i] > 0) {
                r[i] = -1;
                if (map.containsKey(rains[i])) {
                    //有池塘重复下雨，但是没有不下雨天数去排水池，就失败了
                    if (arrayDeque.isEmpty() || map.get(rains[i]) > arrayDeque.getLast())
                        return new int[0];
                    Iterator<Integer> iterator = arrayDeque.iterator();
                    int p = map.get(rains[i]), pos;
                    while ((pos = iterator.next()) < p) ;
                    iterator.remove();
                    r[pos] = rains[i];
                }
                map.put(rains[i], i);
            } else {
                arrayDeque.add(i);
                r[i] = 1;
            }
        }
        return r;
    }
}
