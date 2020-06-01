package com.young.offer;

import java.util.ArrayList;
import java.util.List;

public class Example41 {
    public static void main(String[] args) {
    }

    public int[][] findContinuousSequence(int target) {
        int mid = (1+target)/2;
        List<int []> result = new ArrayList<>();
        int small = 1;
        int big = 2;
        int sum = small+big;
        while (big<=mid&&small<mid){
            if (sum>target){
                //���������ע�⣬Ҫ�ȼ�ȥԭ���ģ�Ȼ����������˳���˾Ͷ����1
                sum-=small;
                small++;
            }else if (sum<target){
                big++;
                sum+=big;
            }else{
              int a[] = new int[big-small+1];
                for (int i = small; i <= big; i++) {
                   a[i-small]=i;
                }
                result.add(a);
                sum-=small;
                small++;
            }
        }
        return result.toArray(new int[result.size()][]);
    }

}
