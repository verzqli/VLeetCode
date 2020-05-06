package me.verzqli.leetcode.everyday;

/**
 * 在一个火车旅行很受欢迎的国度，你提前一年计划了一些火车旅行。在接下来的一年里，你要旅行的日子将以一个名为?days?的数组给出。
 * 每一项是一个从?1?到?365?的整数。
 * <p>
 * 火车票有三种不同的销售方式：
 * <p>
 * 一张为期一天的通行证售价为?costs[0] 美元；
 * 一张为期七天的通行证售价为?costs[1] 美元；
 * 一张为期三十天的通行证售价为?costs[2] 美元。
 * 通行证允许数天无限制的旅行。 例如，如果我们在第 2 天获得一张为期 7 天的通行证，
 * 那么我们可以连着旅行 7 天：第 2 天、第 3 天、第 4 天、第 5 天、第 6 天、第 7 天和第 8 天。
 * <p>
 * 返回你想要完成在给定的列表?days?中列出的每一天的旅行所需要的最低消费。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-cost-for-tickets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode20200506 {
    public static void main(String[] args) {
    }

    public int mincostTickets(int[] days, int[] costs) {
        if (days.length == 1) {
            return costs[0];
        }
        int length = days.length ;
        int startDay = days[0];
        int endDay = days[length-1];
        int index = length-1;
        int[] dp = new int[endDay+30];
        for (int i = endDay; i >= startDay; i--) {
            if (i == days[index]) {
                dp[i] = Math.min(costs[0]+dp[i+1], costs[1] + dp[i + 7]);
                dp[i] = Math.min(dp[i], costs[2] + dp[i + 30]);
               index--;
            }else{
                dp[i]=dp[i+1];
            }

        }
        return dp[startDay];
    }

}
