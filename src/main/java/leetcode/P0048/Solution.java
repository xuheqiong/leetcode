package leetcode.P0048;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 */
public class Solution {

    public static void rotate(int[][] matrix) {

        int n = matrix[0].length;

        if (n == 1) {
            return;
        }

        // i是旋转次数
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n - 2 * i - 1; j++) {
                int tmp0 = matrix[i][i + j];
                int tmp1 = matrix[i + j][n - i - 1];
                int tmp2 = matrix[n - i - 1][n - i - j - 1];
                int tmp3 = matrix[n - i - j - 1][i];

                matrix[i][i + j] = tmp3;
                matrix[i + j][n - i - 1] = tmp0;
                matrix[n - i - 1][n - i - j - 1] = tmp1;
                matrix[n - i - j - 1][i] = tmp2;
            }
        }
    }


    public static void main(String[] args) {

        int[][] nums = new int[][]{{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        rotate(nums);

        for (int i = 0; i < nums.length; i++) {

            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < nums[i].length; j++) {
                row.add(nums[i][j]);
            }

            System.out.println(row);
        }
    }
}