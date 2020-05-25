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
        //��¼t�ַ������ַ������������
        int[] target = new int[128];
        //��¼���������ڵ��ַ������������
        int[] window = new int[128];
        for (int i = 0; i < t.length(); i++) {
            target[t.charAt(i)]++;
        }
        int left = 0, right = 0;
        //��¼��ǰ�������ж��ٸ�t�е��ַ������細��=BADDC  t=ADM
        // ��ʱ����2��������Ϊ����D����1��
        int count = 0;
        int minLength = s.length() + 1;
        //����ַ����Ŀ�ͷ��
        int begin = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            //��¼�´����ڵ��ַ������������
            window[c]++;
            //���Ŀ��s�������c����ַ���������ַ������ȴ����ڵĶ�ʱ������ƥ�䵽��һ����
            // ע�������е����ж�����Ϊǰ�������� window[c]++;���Ѿ���1�����ˡ�
            if (target[c] > 0 && target[c] >= window[c]) {
                count++;
            }
            //��������ڵ��ַ��Ѿ���ȫ������s���ַ�ʱ����Ҫ��left��ʼɾ��ͷ��
            while (count == t.length()) {
                c = s.charAt(left);
                //���Ŀ���а�������ַ���������ַ�target�б�window������ߵ���ʱ����ﵽĿ��
                //���� CCCCCCCAB   ABC  ������Ҫleft�ӵ����һ��Cʱ�����������ͷ��ǰ���ȥ����ЩC������
                if (target[c] > 0 && target[c] >= window[c]) {
                    count--;
                    if (right - left + 1 < minLength) {
                        minLength = right - left + 1;
                        begin = left;
                    }
                }
                //��ȥ������C������,ע�⣬�������һ��CҲҪ��ȥ����Ϊ��right����Ѱ���µ�C
                window[c]--;
                left++;
            }
            right++;
        }
        //ǰ��������һ�������ܵ�ֵ�����������ɻ������ֵ��˵��û�ҵ��Ӵ�
        if (minLength == s.length() + 1) {
            return "";
        } else {
            return s.substring(begin, begin + minLength);
        }
    }
}
