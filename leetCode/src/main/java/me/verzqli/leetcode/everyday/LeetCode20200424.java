package me.verzqli.leetcode.everyday;

/**
 *在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 *
 * ?
 *
 * 示例 1:
 *
 * 输入: [7,5,6,4]
 * 输出: 5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode20200424 {
    public static void main(String[] args) {
    }

    public int reversePairs(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        int[] temp = new int[nums.length];
//        int[] copy = new int[nums.length];
//        for (int i = 0, length = nums.length; i < length; i++) {
//            copy[i] = nums[i];
//        }
      return   merge(nums, 0, nums.length - 1, temp);

    }

    private int merge(int[] nums, int start, int end, int[] temp) {
        if (start==end){
            return 0;
        }
        int mid = (start + end) / 2;
        int leftCount = merge(nums, start, mid, temp);
        int rightCount = merge(nums, mid + 1, end, temp);
        if (nums[mid] <= nums[mid + 1]) {
            return leftCount + rightCount;
        }
        int midCount = count(nums, start, mid, end, temp);

        return leftCount + rightCount + midCount;
    }

    private int count(int[] nums, int start, int mid, int end, int[] temp) {
        for (int i = start; i <= end; i++) {
            temp[i] = nums[i];
        }
        int m = start;
        int n = mid + 1;
        int count = 0;
        for (int i = start; i <= end; i++) {
            if (m == mid + 1) {
                nums[i] = temp[n];
                n++;
            } else if (n == end+1) {
                nums[i] = temp[m];
                m++;
            } else if (temp[m] <= temp[n]) {
                nums[i] = temp[m];
                m++;
            } else {
                nums[i] = temp[n];
                n++;
                count += (mid - m + 1);
            }
        }
        return count;
    }
}
