package me.verzqli.leetcode.weekly;

import java.util.HashMap;
import java.util.Map;

/**
 * 1487. ��֤�ļ���Ψһ
 * ����һ������Ϊ n ���ַ������� names ���㽫�����ļ�ϵͳ�д��� n ���ļ��У��ڵ� i ���ӣ��½���Ϊ names[i] ���ļ��С�
 *
 * ���������ļ� ���� ������ͬ���ļ������������½��ļ���ʹ�õ��ļ����Ѿ���ռ�ã�ϵͳ���� (k) ����ʽΪ���ļ��е��ļ�����Ӻ�׺������ k ���ܱ�֤�ļ���Ψһ�� ��С������ ��
 *
 * ���س���Ϊ n ���ַ������飬���� ans[i] �Ǵ����� i ���ļ���ʱϵͳ��������ļ��е�ʵ�����ơ�
 */
class Weekly194_2 {

    public String[] getFolderNames(String[] names) {
        Map<String, Integer> map = new HashMap<>();
        String[] result = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            if (map.containsKey(names[i])) {
                int count = map.getOrDefault(names[i], 0) + 1;
                String newStr = names[i] + "(" + (count - 1) + ")";
                //���µ��ַ�����map��Ҳ��ʱ����������ĵ�һ�������ǰ�����ֱ���a��a(1)
                //�����newStrҲ��a(1),��������ѭ��count��ֱ���ۼӵ�map�в����ڼ���
                if (map.containsKey(newStr)) {
                    while (map.containsKey(newStr)) {
                        count++;
                        newStr = names[i] + "(" + (count - 1) + ")";
                    }
                }
                //��¼��ǰ�ַ���������
                map.put(names[i], count);
                //��¼���ַ����������϶���1.
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
