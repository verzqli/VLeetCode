package com.young.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Example40 {
    public static void main(String[] args) {
        new Example40().findContinuousSequence(9);
    }

    public int[][] findContinuousSequence(int target) {
        int mid = (1+target)/2;
        List<int []> result = new ArrayList<>();
        int small = 1;
        int big = 2;
        int sum = small+big;
        while (big<=mid&&small<mid){
            if (sum>target){
                //这里和下面注意，要先减去原来的，然后在自增，顺序反了就多减了1
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
