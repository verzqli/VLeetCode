package com.young.offer;

public class Example35 {
    public static void main(String[] args) {
    }

    public char firstUniqChar(String s) {
        int[] array = new int[256];
        for (char c:s.toCharArray()) {
            array[c]++;
        }
        for (char c:s.toCharArray()) {
            if (array[c]==1){
                return c;
            }
        }
     return ' ';
    }

}
