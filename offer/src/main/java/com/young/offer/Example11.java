package com.young.offer;

/**
 * 实现函数的整数次方功能，不需要考虑大数问题
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
        //0的负次方无意义
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

    //dobule计算精度有损失，所以在0.0000001范围内就默认相等
    private boolean equal(double base, double v) {
        return base - v > -0.0000001 && base - v < 0.0000001;
    }


}
