package me.verzqli.leetcode.everyday;

/**
 * 238. ��������������ĳ˻�
 * ����һ������Ϊ n ���������� nums������ n > 1������������� output ������ output[i] ���� nums �г� nums[i] ֮�������Ԫ�صĳ˻���
 *
 *
 *
 * ʾ��:
 *
 * ����: [1,2,3,4]
 * ���: [24,12,8,6]
 *
 *
 * ��ʾ����Ŀ���ݱ�֤����֮������Ԫ�ص�ȫ��ǰ׺Ԫ�غͺ�׺���������������飩�ĳ˻����� 32 λ������Χ�ڡ�
 *
 * ˵��: �벻Ҫʹ�ó��������� O(n) ʱ�临�Ӷ�����ɴ��⡣
 *
 * ���ף�
 * ������ڳ����ռ临�Ӷ�����������Ŀ�𣿣� ���ڶԿռ临�Ӷȷ�����Ŀ�ģ�������鲻����Ϊ����ռ䡣��
 */
class LeetCode20200604 {
    public static void main(String[] args) {
    }

    public int[] productExceptSelf(int[] nums) {
        int [] left = new int[nums.length];
        int [] right = new int[nums.length];
        left[0]=1;
        right[nums.length-1] = 1;
        for (int i = 1; i <nums.length ; i++) {
            left[i]=left[i-1]*nums[i-1];
        }
        for (int i = nums.length-1; i >0 ; i--) {
            right[i-1]=right[i]*nums[i];
        }
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i]=left[i]*right[i];
        }
        return result;
    }

}
