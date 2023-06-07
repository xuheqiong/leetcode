package leetcode.P1137;

/**
 * 泰波那契序列 Tn 定义如下：
 * T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
 * 给你整数 n，请返回第 n 个泰波那契数 Tn 的值。
 * <p>
 * 思路：动态规划
 *
 * @author xuhq
 * @date 2023/6/6 18:21
 */
public class Solution {
    public int tribonacci(int n) {

        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        int T0 = 0;
        int T1 = 1;
        int T2 = 1;

        for (int i = 3; i <= n; i++) {
            int T3 = T0 + T1 + T2;
            T0 = T1;
            T1 = T2;
            T2 = T3;
        }

        return T2;
    }
}
