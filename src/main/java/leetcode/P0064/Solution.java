package leetcode.P0064;

/**
 * 给定一个包含非负整数的 mxn网格grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 * <p>
 * 思路：动态规划
 */
public class Solution {

    public int minPathSum(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        // 这个数组代表从起点到grid[m][n]的最短路径
        int[][] dp = new int[m][n];

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j <= i; j++) {
                sum += grid[0][j];
            }
            dp[0][i] = sum;
        }

        for (int i = 0; i < m; i++) {
            int sum = 0;
            for (int j = 0; j <= i; j++) {
                sum += grid[j][0];
            }
            dp[i][0] = sum;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j] + grid[i][j], dp[i][j - 1] + grid[i][j]);
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        long start = System.nanoTime();
        int[][] grid = new int[][]{{1, 3, 6}, {2, 5, 1}, {7, 2, 1}};
        System.out.println(solution.minPathSum(grid));
        long end = System.nanoTime();
        System.out.println((end - start) / 1000000);
    }
}
