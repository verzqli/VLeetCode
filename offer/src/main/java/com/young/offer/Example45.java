package com.young.offer;

class Example45 {
    public static void main(String[] args) {
    }


    public int lastRemaining(int n, int m) {
        if (n < 1 && m < 1) {
            return -1;
        }
        int result = 0;
        //这里是等于n，因为长度是n
        for (int i = 2; i <= n; i++) {
            //注意这里不是%n,而是%当前的长度。
            result = (result + m) % i;
        }
        return result;
    }
}