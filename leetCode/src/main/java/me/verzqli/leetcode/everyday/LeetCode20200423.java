package me.verzqli.leetcode.everyday;

public class LeetCode20200423 {


    public static void main(String[] args) {
        System.out.printf("aa" + (new LeetCode20200423().waysToChange(5)));
        ;
    }

    public int waysToChange(int n) {
         int count = 0;
         int[] value = {25, 10, 5, 1};
          int mod = 1000000007;
        int[] array = new int[n + 1];
        array[0] = 1;
        for (int i = 0; i < value.length; i++) {
            int money = value[i];
            for (int j = money; j <= n; j++) {
                array[j] = (array[j] + array[j - money]) % mod;
            }
        }
        return array[n];
    }



}
