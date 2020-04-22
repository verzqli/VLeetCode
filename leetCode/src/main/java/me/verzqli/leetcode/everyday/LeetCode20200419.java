package me.verzqli.leetcode.everyday;

import java.util.HashMap;
/**
 * LeetCode 466
 * �� n �����ӵ��ַ��� s ����ַ��� S������?S = [s,n]�����磬["abc",3]=��abcabcabc����
 * <p>
 * ������ǿ��Դ� s2?��ɾ��ĳЩ�ַ�ʹ���Ϊ s1������ַ��� s1?���Դ��ַ��� s2 ��á����磬���ݶ��壬"abc" ���Դ� ��abdbec�� ��ã������ܴ� ��acbbe�� ��á�
 * <p>
 * ���ڸ��������ǿ��ַ��� s1?�� s2��ÿ����� 100 ���ַ��������������� 0 �� n1 �� 106?�� 1 �� n2 �� 106�����ڿ����ַ��� S1 �� S2������ S1=[s1,n1]?��S2=[s2,n2] ��
 * <p>
 * �����ҳ�һ����������ʹ[S2,M] �� S1?��õ�������� M ��
 * <p>
 * ?
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/count-the-repetitions
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
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
                    //���ﲻ��s2Length-1����Ϊ���ﲻ���±꣬��ͬ�ż�һ��������ǳ���
                    //����жϷ������������һ���ģ�������������жϡ�
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
                //������n1-s1Count  ������n1-history[0]����Ϊs2Count�Ѿ�����ǰ����ֵ��ˣ����Գ�ȥǰ�������ġ�
                int circleCount = (n1 - s1Count) / (s1Circle);
                s1Count += circleCount * s1Circle;
                s2Count += circleCount * s2Circle;
            }
        }
        //�����ȫ��S1�������������S2������Ȼ�����S2���ӵ���������������S2���ӵ����ֵ
        return s2Count / n2;
    }

}
