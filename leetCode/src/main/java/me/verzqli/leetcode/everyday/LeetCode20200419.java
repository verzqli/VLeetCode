package me.verzqli.leetcode.everyday;

import java.util.HashMap;
/**
 * LeetCode 466
 * 由 n 个连接的字符串 s 组成字符串 S，记作?S = [s,n]。例如，["abc",3]=“abcabcabc”。
 * <p>
 * 如果我们可以从 s2?中删除某些字符使其变为 s1，则称字符串 s1?可以从字符串 s2 获得。例如，根据定义，"abc" 可以从 “abdbec” 获得，但不能从 “acbbe” 获得。
 * <p>
 * 现在给你两个非空字符串 s1?和 s2（每个最多 100 个字符长）和两个整数 0 ≤ n1 ≤ 106?和 1 ≤ n2 ≤ 106。现在考虑字符串 S1 和 S2，其中 S1=[s1,n1]?、S2=[s2,n2] 。
 * <p>
 * 请你找出一个可以满足使[S2,M] 从 S1?获得的最大整数 M 。
 * <p>
 * ?
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-the-repetitions
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode20200419 {
    public static void main(String[] args) {

    }

    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        if (n1 == 0) return 0;
        char[] s1Array = s1.toCharArray();
        char[] s2Array = s2.toCharArray();
        int s1Length = s1Array.length;
        int s2Length = s2Array.length;
        int s2CircleIndex = 0;
        int s1Count = 0;
        int s2Count = 0;
        HashMap<Integer, int[]> map = new HashMap<>();
        while (s1Count < n1) {
            for (int i = 0; i < s1Length; i++) {
                if (s1Array[i] == s2Array[s2CircleIndex]) {
                    s2CircleIndex++;
                    //这里不用s2Length-1，因为这里不是下标，相同才加一，计算的是长度
                    //这个判断放里面放外面是一样的，放在里面减少判断。
                    if (s2CircleIndex == s2Length) {
                        s2Count++;
                        s2CircleIndex = 0;
                    }
                }
            }
            s1Count++;
            if (!map.containsKey(s2CircleIndex)) {
                map.put(s2CircleIndex, new int[]{s1Count, s2Count});
            } else {
                int[] history = map.get(s2CircleIndex);
                int s1Circle = s1Count - history[0];
                int s2Circle = s2Count - history[1];
                //这里是n1-s1Count  而不是n1-history[0]，因为s2Count已经加了前面出现的了，所以出去前面计算过的。
                int circleCount = (n1 - s1Count) / (s1Circle);
                s1Count += circleCount * s1Circle;
                s2Count += circleCount * s2Circle;
            }
        }
        //计算出全部S1可以容量的最多S2数量，然后除以S2叠加的数量，就是容量S2叠加的最大值
        return s2Count / n2;
    }

}
