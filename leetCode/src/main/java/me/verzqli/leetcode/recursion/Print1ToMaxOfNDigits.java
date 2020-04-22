package me.verzqli.leetcode.recursion;

/**
 * <pre>
 *     author: XuPei
 *     time  : 2019/7/9
 *     desc  : ��1��ӡ��Nλ��ȫ������
 *             ����NΪ3 ��ô��ӡ1,2.3������999
 *             ��Ҫ���ǵ�©��:1.�����ֲ���nλ��ʱ�����������ֵ�ǰ�油0����ӡ��ʱ����Щ��λ��0��Ӧ�ô�ӡ����
 *                          2:���Ǵ������⣬�п��ܼ�ʹ������(int)������(long)���������
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
     * �ݹ�Ĵ����߼�Ϊ��index�ǵ�2��Ҳ���Ǹ�λ����Ȼ�����1-9 ��ʱ���λ����������
     * ����ʮλ����1����ʱ����019 ����index��1�� != n - 1��2��������ʱ����������ְ�index+1
     * ���������λ1-9��ѭ��
     * ʮλ���׵�ѭ��:
     * number008   n= 3   index=2
     * number009   n= 3   index=2
     * number019   n= 3   index=1
     * number010   n= 3   index=2
     * ��λ���׵�ѭ��:
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
