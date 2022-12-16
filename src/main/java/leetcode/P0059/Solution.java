package leetcode.P0059;

import java.util.Arrays;

/**
 * 给你一个正整数n ，生成一个包含 1 到n2所有元素，且元素按顺时针顺序螺旋排列的n x n 正方形矩阵 matrix 。
 * 提示：
 * 1 <= n <= 20
 */
public class Solution {

    private final int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int[][] generateMatrix(int n) {

        // m x n 的矩阵
        boolean[][] used = new boolean[n][n];

        int[][] matrix = new int[n][n];

        used[0][0] = true;

        int row = 0;
        int col = 0;
        int val = 1;

        matrix[row][col] = val;
        for (int i = 0; i < directions.length; ) {
            int[] direction = directions[i];
            row += direction[0];
            col += direction[1];

            // 还没有触底
            while (canContinue(n, row, col, used)) {
                used[row][col] = true;
                matrix[row][col] = ++val;
                row += direction[0];
                col += direction[1];
            }

            // 当前位置已经被访问过，要回退
            int[] rollback = directions[(i - 2 + directions.length) % directions.length];
            row += rollback[0];
            col += rollback[1];

            // 每一轮结束的时候要判断下上下左右四个方向是否都已经没路了
            if (hasNoMove(n, row, col, directions, used)) {
                break;
            }

            i = (i + 1) % directions.length;
        }

        return matrix;
    }

    /**
     * 当前方向已经触底了，要换个方向继续
     */
    private boolean canContinue(int n, int row, int col, boolean[][] used) {
        return row < n && col < n && row >= 0 && col >= 0 && !used[row][col];
    }

    private boolean hasNoMove(int n, int row, int col, int[][] directions, boolean[][] used) {

        // 如果上下左右四个位置都没有可以走的路了
        for (int i = 0; i < directions.length; i++) {
            int[] direction = directions[i];
            int r = row + direction[0];
            int c = col + direction[1];
            if (canContinue(n, r, c, used)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int n = 1;
        System.out.println(Arrays.deepToString(solution.generateMatrix(n)));
    }
}

