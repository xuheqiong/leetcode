package leetcode.P0746;

/**
 * 给你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。一旦你支付此费用，即可选择向上爬一个或者两个台阶。
 * 你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。
 * 请你计算并返回达到楼梯顶部的最低花费。
 * <p>
 * 思路：动态规划
 * 楼顶假设是cost[n]，那么cost[n]=Min(cost[n-1] + dp[n-1], cost[n-2] + dp[n-2])
 *
 * @author xuhq
 * @date 2023/6/7 16:27
 */
public class Solution {

    public int minCostClimbingStairs(int[] cost) {

        int cost0 = 0;
        int cost1 = 0;

        for (int i = 2; i <= cost.length; i++) {
            int costi = Math.min(cost[i - 2] + cost0, cost[i - 1] + cost1);
            cost0 = cost1;
            cost1 = costi;
        }

        return cost1;
    }
}
