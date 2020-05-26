package me.verzqli.leetcode.everyday;

/**
 * 287. Ѱ���ظ���
 * <p>
 * ����һ������?n + 1 ������������?nums�������ֶ��� 1 �� n?֮�䣨���� 1 �� n������֪���ٴ���һ���ظ�������������ֻ��һ���ظ����������ҳ�����ظ�������
 * <p>
 * ʾ�� 1:
 * <p>
 * ����: [1,3,4,2,2]
 * ���: 2
 * ʾ�� 2:
 * <p>
 * ����: [3,1,3,4,2]
 * ���: 3
 * ˵����
 * <p>
 * ���ܸ���ԭ���飨����������ֻ���ģ���
 * ֻ��ʹ�ö���� O(1) �Ŀռ䡣
 * ʱ�临�Ӷ�С�� O(n2) ��
 * ������ֻ��һ���ظ������֣��������ܲ�ֹ�ظ�����һ�Ρ�
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/find-the-duplicate-number
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class LeetCode20200526 {
    //����ָ�뷽��
    public int findDuplicate(int[] nums) {
        int fast = nums[nums[0]], slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    //�����Ʒ���
    public int findDuplicate2(int[] nums) {
        int length = nums.length;
        int result = 0, maxBit = 32;
        while ((length) >> maxBit == 0) {
            maxBit--;
        }
        for (int i = 0; i < maxBit; i++) {
            int x = 0,y=0;
            //����1~n������ÿ����λ�ĺͺ͵�ǰ����û����λ�ĺͣ�Ȼ�����Ա�
            for (int j = 0; j < length; j++) {
                if ((nums[j]&(1<<i))!=0){
                    x++;
                }
                if (j>0&&(j&(1<<i))!=0){
                    y++;
                }
            }
            if (x>y){
                result|= (1<<i);
            }
        }
        return result;
    }
}
