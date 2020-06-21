package me.verzqli.leetcode.weekly;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author verzqli
 * @date 2020/6/21
 * @Desc 1488. �����ˮ����
 * ��Ĺ��������������������к���һ��ʼ���ǿյġ����� n �����������ʱ������� n �������ǿյģ���ô���ͻ�װ��ˮ��������������ᷢ����ˮ�����Ŀ���Ǳ�������һ������������ˮ��
 * <p>
 * ����һ���������� rains �����У�
 * <p>
 * rains[i] > 0 ��ʾ�� i ��ʱ���� rains[i] �����������ꡣ
 * rains[i] == 0 ��ʾ�� i ��û�к��������꣬�����ѡ�� һ�� ������ ��� ���������ˮ��
 * �뷵��һ������ ans �����㣺
 * <p>
 * ans.length == rains.length
 * ��� rains[i] > 0 ����ôans[i] == -1 ��
 * ��� rains[i] == 0 ��ans[i] ����� i ��ѡ���ɵĺ�����
 * ����ж��ֿ��н⣬�뷵�������е� ����һ�� �����û�취��ֹ��ˮ���뷵��һ�� �յ����� ��
 * <p>
 * ��ע�⣬�����ѡ����һ��װ��ˮ�ĺ�����������һ���յĺ������������ѡ����һ���յĺ�������ô�����·����������뿴ʾ�� 4����
 */
class Weekly194_3 {
    public int[] avoidFlood(int[] rains) {
        int[] r = new int[rains.length];
        //��¼�����������
        LinkedList<Integer> arrayDeque = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < rains.length; i++) {
            if (rains[i] > 0) {
                r[i] = -1;
                if (map.containsKey(rains[i])) {
                    //�г����ظ����꣬����û�в���������ȥ��ˮ�أ���ʧ����
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
