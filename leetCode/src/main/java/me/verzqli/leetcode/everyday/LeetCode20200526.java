package me.verzqli.leetcode.everyday;

/**
 * 287. 寻找重复数
 * <p>
 * 给定一个包含?n + 1 个整数的数组?nums，其数字都在 1 到 n?之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,4,2,2]
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [3,1,3,4,2]
 * 输出: 3
 * 说明：
 * <p>
 * 不能更改原数组（假设数组是只读的）。
 * 只能使用额外的 O(1) 的空间。
 * 时间复杂度小于 O(n2) 。
 * 数组中只有一个重复的数字，但它可能不止重复出现一次。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-the-duplicate-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode20200526 {
    //快慢指针方法
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

    //二进制方法
    public int findDuplicate2(int[] nums) {
        int length = nums.length;
        int result = 0, maxBit = 32;
        while ((length) >> maxBit == 0) {
            maxBit--;
        }
        for (int i = 0; i < maxBit; i++) {
            int x = 0,y=0;
            //计算1~n所有数每个进位的和和当前数组没个进位的和，然后作对比
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
