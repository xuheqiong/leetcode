package leetcode.P0054;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个 m 行 n 列的矩阵matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 *
 * @author user
 * @date 2022/12/15 21:20
 */
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        // m x n 的矩阵
        boolean[][] used = new boolean[matrix.length][matrix[0].length];

        int m = 0;
        int n = 0;

        List<Integer> list = new ArrayList<>();
        list.add(matrix[0][0]);
        used[0][0] = true;

        for (int i = 0; i < directions.length; ) {
            int[] direction = directions[i];
            m += direction[0];
            n += direction[1];

            // 还没有触底
            while (canContinue(matrix, m, n, used)) {
                list.add(matrix[m][n]);
                used[m][n] = true;
                m += direction[0];
                n += direction[1];
            }

            // 当前位置已经被访问过，要回退
            int[] rollback = directions[(i - 2 + directions.length) % directions.length];
            m += rollback[0];
            n += rollback[1];

            // 每一轮结束的时候要判断下上下左右四个方向是否都已经没路了
            if (hasNoMove(matrix, m, n, directions, used)) {
                break;
            }

            i = (i + 1) % directions.length;
        }
        return list;
    }

    /**
     * 当前方向已经触底了，要换个方向继续
     */
    private boolean canContinue(int[][] matrix, int m, int n, boolean[][] used) {
        return m < matrix.length && n < matrix[0].length && m >= 0 && n >= 0 && !used[m][n];
    }

    private boolean hasNoMove(int[][] matrix, int m, int n, int[][] directions, boolean[][] used) {

        // 如果上下左右四个位置都没有可以走的路了
        for (int i = 0; i < directions.length; i++) {
            int[] direction = directions[i];
            int r = m + direction[0];
            int c = n + direction[1];
            if (canContinue(matrix, r, c, used)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

//        int[][] matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        int[][] matrix = new int[][]{{1}};
        List<Integer> list = solution.spiralOrder(matrix);

        System.out.println(list);
    }
}

