package com.young.offer;

class Example45 {
    public static void main(String[] args) {
    }


    public int lastRemaining(int n, int m) {
        if (n < 1 && m < 1) {
            return -1;
        }
        int result = 0;
        //�����ǵ���n����Ϊ������n
        for (int i = 2; i <= n; i++) {
            //ע�����ﲻ��%n,����%��ǰ�ĳ��ȡ�
            result = (result + m) % i;
        }
        return result;
    }
}