package me.verzqli.leetcode.array;

/**
 * <pre>
 *     author: Windows XP
 *     time  : 2019/5/14
 *     desc  :在二维想左和向下递增数组中寻找数
 * </pre>
 */

/**
 * Input:
 * matrix = [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * target = 3
 * Output: true
 */
public class FindNumberInTwoDimensionalIncrementArray {
    public static void main() {
        int matrix[][]={{1,3,5,7},{10,11,16,20},{23,30,34,50}};
        System.out.println("args = [" + searchMatrix(matrix,13) + "]");
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length==0||matrix[0].length==0){
            return false;
        }
        int col = matrix.length-1;//行
        int row = matrix[0].length-1;//列
        int targetCol=col,targetRow=0;
        boolean result =false;
        while(targetCol>=0&&targetRow<=row){
          if (matrix[targetCol][targetRow]>target){
              targetCol--;
          }else if (matrix[targetCol][targetRow]<target){
              targetRow++;
          }else{
              result=true;
              break;
          }
        }
        return result;
    }
}
