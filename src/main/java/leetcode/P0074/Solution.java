package leetcode.P0074;

/**
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * <p>
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * <p>
 * 思路：这实际就是个升序的数组中查某个元素的问题。用二分查找法
 *
 * @author xuhq
 * @date 2023/5/26 11:34
 */
public class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {

        int row = matrix.length;
        int col = matrix[0].length;

        return searchMatrix(matrix, row, col, 0, row * col - 1, target);
    }

    private boolean searchMatrix(int[][] matrix, int row, int col, int l, int r, int target) {
        int row1 = l / col;
        int col1 = l % col;

        // 递归结束的条件
        if (l > r) {
            return false;
        } else if (l == r) {
            return matrix[row1][col1] == target;
        }

        // l < r
        int mid = (l + r - 1) / 2;
        int midCol = mid % col;
        int midRow = mid / col;

        // target比中间的大
        if (target > matrix[midRow][midCol]) {
            return searchMatrix(matrix, row, col, mid + 1, r, target);
        } else if (target < matrix[midRow][midCol]) {
            return searchMatrix(matrix, row, col, l, mid, target);
        }

        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] matrix = new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};

//        int[][] matrix = new int[][]{{1}, {3}};
//        int[][] matrix = new int[][]{{1, 1}};
        System.out.println(solution.searchMatrix(matrix, 16));
    }
}
