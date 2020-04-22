package com.young.offer;

/**
 * ʵ�ֺ����������η����ܣ�����Ҫ���Ǵ�������
 */
public class Example11 {

    public static void main(String[] args) {

        System.out.printf("a" + (new Example11().solve(3, -10)));
    }

    public double solve(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }
        //0�ĸ��η�������
        if (equal(base, 0.0) && exponent < 0) {
            return 0;
        }
        int absExponent = exponent;
        if (exponent < 0) {
            absExponent = -exponent;
        }
        double result = pow(base, absExponent);
        if (exponent<0){
            result=1.0/result;
        }
        return result;
    }

    private double pow(double base, int absExponent) {
        if (absExponent == 0) {
            return 1;
        }
        if (absExponent == 1) {
            return base;
        }
        double result = pow(base, absExponent >> 1);
        result *= result;
        if ((absExponent & 1) == 1) {
            result *= base;
        }
        return result;
    }

    //dobule���㾫������ʧ��������0.0000001��Χ�ھ�Ĭ�����
    private boolean equal(double base, double v) {
        return base - v > -0.0000001 && base - v < 0.0000001;
    }


}
