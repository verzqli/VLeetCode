package me.verzqli.leetcode.everyday;

/**
 * 给你一个整数数组?nums 和一个整数 k。
 *
 * 如果某个 连续 子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。
 *
 * 请返回这个数组中「优美子数组」的数目。
 *
 * ?示例 1：
 *
 * 输入：nums = [1,1,2,1,1], k = 3
 * 输出：2
 * 解释：包含 3 个奇数的子数组是 [1,1,2,1] 和 [1,2,1,1] 。
 * 示例 2：
 *
 * 输入：nums = [2,4,6], k = 1
 * 输出：0
 * 解释：数列中不包含任何奇数，所以不存在优美子数组。
 * 示例 3：
 *
 * 输入：nums = [2,2,2,1,2,2,1,2,2,2], k = 2
 * 输出：16
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-number-of-nice-subarrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode20200421 {
    public static void main(String[] args) {
        System.out.printf("aaaa" + (new LeetCode20200421().numberOfSubarrays(new int[]{1, 1, 1, 1, 1}, 1)));
    }

    public int numberOfSubarrays(int[] nums, int k) {

        int length = nums.length;
        int[] array = new int[length + 2];
        int count = 0;
        int result=0;
        for (int i = 0; i < length; i++) {
            if ((nums[i] & 1) == 1) {
                array[++count] = i;
            }
        }
        array[0] = -1;
        array[++count] = length;
        for (int i = 1; i+k <= count; i++) {
            result+=(array[i]-array[i-1])*(array[i+k]-array[i+k-1]);
        }
        return result;
    }
}
