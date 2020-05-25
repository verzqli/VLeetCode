package me.verzqli.leetcode.everyday;

/**
 * @author verzqli
 * @date 2020/5/23
 * @Desc
 */
public class LeetCode20200523 {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        //记录t字符串的字符情况和数量。
        int[] target = new int[128];
        //记录滑动窗口内的字符情况和数量。
        int[] window = new int[128];
        for (int i = 0; i < t.length(); i++) {
            target[t.charAt(i)]++;
        }
        int left = 0, right = 0;
        //记录当前窗口内有多少个t中的字符，例如窗口=BADDC  t=ADM
        // 此时就是2，不会因为两个D而多1。
        int count = 0;
        int minLength = s.length() + 1;
        //最短字符串的开头。
        int begin = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            //记录下窗口内的字符情况和数量。
            window[c]++;
            //如果目标s内有这个c这个字符，且这个字符数量比窗口内的多时，才算匹配到了一个，
            // 注意这里有等于判断是因为前面先做了 window[c]++;，已经加1数量了。
            if (target[c] > 0 && target[c] >= window[c]) {
                count++;
            }
            //如果窗口内的字符已经完全包含了s的字符时，就要从left开始删除头。
            while (count == t.length()) {
                c = s.charAt(left);
                //如果目标中包含这个字符，且这个字符target中比window多余或者等于时才算达到目标
                //例如 CCCCCCCAB   ABC  这里需要left加到最后一个C时，才算遍历到头，前面减去的那些C都不算
                if (target[c] > 0 && target[c] >= window[c]) {
                    count--;
                    if (right - left + 1 < minLength) {
                        minLength = right - left + 1;
                        begin = left;
                    }
                }
                //减去例子中C的数量,注意，这里最后一个C也要减去，是为了right向后加寻找新的C
                window[c]--;
                left++;
            }
            right++;
        }
        //前面设置了一个不可能的值，如果遍历完成还是这个值，说明没找到子串
        if (minLength == s.length() + 1) {
            return "";
        } else {
            return s.substring(begin, begin + minLength);
        }
    }
}
