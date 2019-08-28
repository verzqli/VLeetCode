package me.verzqli.leetcode.recursion;

/**
 * <pre>
 *     author: XuPei
 *     time  : 2019/7/9
 *     desc  : 从1打印到N位的全部数字
 *             比如N为3 那么打印1,2.3。。。999
 *             需要考虑的漏洞:1.当数字不够n位的时候，我们在数字的前面补0，打印的时候这些补位的0不应该打印出来
 *                          2:考虑大数问题，有可能即使用整型(int)或长整型(long)都会溢出。
 * </pre>
 */
public class Print1ToMaxOfNDigits {
    public static void main(String[] args) {
        print1ToMaxOfNDigits2(3);
    }

    public static void print1ToMaxOfNDigits2(int n) {
        if (n < 0) {
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < n; i++) {
            stringBuffer.append('0');
        }
        for (int i = 0; i < 10; i++) {
            stringBuffer.setCharAt(0, (char) (i + '0'));
            print1ToMaxOfNDigits2Core(stringBuffer, n, 0);
        }
    }

    /**
     * 递归的大致逻辑为把index涨到2，也就是个位数，然后输出1-9 这时候个位数的输出完毕
     * 返回十位数加1，这时候是019 但是index（1） != n - 1（2）所以这时候不输出返回又把index+1
     * 继续输出个位1-9的循环
     * 十位进阶的循环:
     * number008   n= 3   index=2
     * number009   n= 3   index=2
     * number019   n= 3   index=1
     * number010   n= 3   index=2
     * 百位进阶的循环:
     * number098   n= 3   index=2
     * number099   n= 3   index=2
     * number199   n= 3   index=0
     * number109   n= 3   index=1
     * number100   n= 3   index=2
     * number101   n= 3   index=2
     */
    private static void print1ToMaxOfNDigits2Core(StringBuffer number, int n, int index) {
        System.out.println("number"+number+"   n= "+n+"   index="+index);
        if (index == n - 1) {
//            printNumber(number);
            return;
        }
        for (int i = 0; i < 10; i++) {
            number.setCharAt(index + 1, (char) (i + '0'));
            print1ToMaxOfNDigits2Core(number, n, index + 1);
        }
    }

    private static void printNumber(StringBuffer number) {
        boolean isBegining0 = true;
        for (int i = 0; i < number.length(); i++) {
            if (isBegining0 && number.charAt(i) != '0') {
                isBegining0 = false;
            }
            if (!isBegining0) {
                System.out.print(number.charAt(i));
            }
        }
        System.out.println();
    }
}
