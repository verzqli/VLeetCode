package com.young.offer;

public class Example8 {

    public int solve(int[] array) throws Exception {
        if (array.length == 0) {
            throw new Exception("数组为空，无最小值");
        }
        if (array.length == 1) {
            return array[0];
        }
        int start = 0;
        int end = array.length - 1;
        int mid = start;
        //因为是递增，第一个元素一定是大于旋转后的最后一个元素，如果第一次循环就不成立，说明旋转了0个元素，那么最小值就是第一个元素
        //所以mid=start 直接输出array[mid]即可
        while (array[start] >= array[end]) {
            if (end - start == 1) {
                mid = end;
                break;
            }
            mid = (start + end) / 2;
            if (array[mid] == array[start] && array[mid] == array[end]) {
                return Order(array, start, end);
            }
            if (array[mid] >= array[start]) {
                start = mid;
            } else if (array[mid] <= array[end]) {
                end = mid;
            }

        }
        return array[mid];
    }


    /**
     * 当一个原数组为``{0,1,1,1,1}``时，数组``{1,0, 1, 1, 1}``和数组``{1,1, 1,0, 1}``都可以看做原数组的旋转，
     * 而且旋转后的数组，头尾中间三个数都是相等的，并不能判断中间点在哪个子数组上，所以需要对上面代码增加一些特例判断
     */
    private int Order(int[] array, int start, int end) {
        int result = array[start];
        for (int i = start + 1; i < end; i++) {
            if (result > array[i]) {
                result = array[i];
            }
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        int n = 8;
        int count = 0;
        while (n > 0) {
            count++;
            n = (n - 1) & n;
        }
        System.out.printf(""+count);
    }

}
