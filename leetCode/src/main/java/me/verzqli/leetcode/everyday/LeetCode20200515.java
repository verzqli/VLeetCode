package me.verzqli.leetcode.everyday;

import java.util.HashMap;
import java.util.Map;

public class LeetCode20200515 {
    public static void main(String[] args) {
    }

    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int count=0;
        int temp=0;
        for (int i = 0; i < nums.length; i++) {
            temp+=nums[i];
            //�����ǰ�ۼ�ǰ׺ֵ����k���ͼ�һ
            if (temp==k){
                count++;
            }
            //����temp=15��kΪ4,���ǰ����ֹ�11��ǰ׺�ͣ���ô�϶����ں�ΪK�����飬
            // �����͵���ǰ�����ǰ׺��Ϊ11�Ĵ���
            if (map.containsKey(temp-k)){
                count+=map.get(temp-k);
            }
            //���map�в��������ǰ׺�;ͼ�1��������ھͼ�1
            map.put(temp,map.getOrDefault(temp,0)+1);

        }
        return count;
    }

}
