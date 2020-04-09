package com.young.offer;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Example28 {
    StringBuilder builder = new StringBuilder();
    HashSet   set=new HashSet();;
    public static void main(String[] args) {
        new Example28().solve("abcd");
    }

    public void solve(String s) {
        char[] chars = s.toCharArray();
        dfs(chars,0);

    }

    private void dfs(char[] chars,int i ) {
        if (i==chars.length-1){
            System.out.println(Arrays.toString(chars));
            return;
        }
        set=new HashSet();
        for (int j = i; j < chars.length; j++) {
            if (set.contains(chars[i])){
                continue;
            }
            set.add(chars[i]);
            swap(chars,i,j);
            dfs(chars,i+1);
            swap(chars,i,j);
        }
    }

    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i]=chars[j];
        chars[j]=temp;
    }

}
