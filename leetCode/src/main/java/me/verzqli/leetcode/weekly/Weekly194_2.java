package me.verzqli.leetcode.weekly;

import java.util.HashMap;
import java.util.Map;

/**
 * 1487. 保证文件名唯一
 * 给你一个长度为 n 的字符串数组 names 。你将会在文件系统中创建 n 个文件夹：在第 i 分钟，新建名为 names[i] 的文件夹。
 *
 * 由于两个文件 不能 共享相同的文件名，因此如果新建文件夹使用的文件名已经被占用，系统会以 (k) 的形式为新文件夹的文件名添加后缀，其中 k 是能保证文件名唯一的 最小正整数 。
 *
 * 返回长度为 n 的字符串数组，其中 ans[i] 是创建第 i 个文件夹时系统分配给该文件夹的实际名称。
 */
class Weekly194_2 {

    public String[] getFolderNames(String[] names) {
        Map<String, Integer> map = new HashMap<>();
        String[] result = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            if (map.containsKey(names[i])) {
                int count = map.getOrDefault(names[i], 0) + 1;
                String newStr = names[i] + "(" + (count - 1) + ")";
                //当新的字符串在map中也有时，就是上面的第一种情况，前两个分别是a和a(1)
                //这里的newStr也是a(1),所以我们循环count，直到累加到map中不存在即可
                if (map.containsKey(newStr)) {
                    while (map.containsKey(newStr)) {
                        count++;
                        newStr = names[i] + "(" + (count - 1) + ")";
                    }
                }
                //记录当前字符串的数量
                map.put(names[i], count);
                //记录新字符串数量，肯定是1.
                map.put(newStr, 1);
                result[i] = newStr;
            } else {
                map.put(names[i], 1);
                result[i] = names[i];
            }
        }
        return result;
    }
}
