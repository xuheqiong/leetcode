package leetcode.P0070;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 思路：动态规划
 * 爬1层：1种方法
 * 爬2层：2种方法（1级1级爬，或者直接爬2级）
 * 爬3层：3种方法（1+2）
 * ...
 * 爬N层：爬N-1层+爬N-2层
 *
 * @author xuhq
 * @date 2023/6/6 17:44
 */
public class Solution {

    public int climbStairs1(int n) {
        int[] memo = new int[n + 1];
        return climbStairs(n, memo);
    }

    private int climbStairs(int n, int[] memo) {

        if (memo[n] > 0) {
            return memo[n];
        }

        if (n == 1) {
            memo[n] = 1;
            return 1;
        }

        if (n == 2) {
            memo[n] = 2;
            return 2;
        }

        memo[n] = climbStairs(n - 1, memo) + climbStairs(n - 2, memo);
        return memo[n];
    }

    public int climbStairs2(int n) {
        if (n == 1) {
            return 1;
        }

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    public int climbStairs3(int n) {
        if (n == 1) {
            return 1;
        }

        int first = 1;
        int second = 2;

        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }

        return second;
    }

}
