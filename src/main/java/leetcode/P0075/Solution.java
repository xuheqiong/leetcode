package leetcode.P0075;

import java.util.Arrays;

/**
 * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * 必须在不使用库内置的 sort 函数的情况下解决这个问题。
 * <p>
 * n == nums.length
 * 1 <= n <= 300
 * nums[i] 为 0、1 或 2
 * <p>
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 *
 * @author xuhq
 * @date 2023/5/25 18:22
 */
public class Solution {

    public void sortColors(int[] nums) {

        // 三路快速排序算法
        // 定义：[l, zero]=0, [zero+1, one]=1, [one+1, r]=2
        int zero = -1, i = 0, two = nums.length;

        while (i < two) {
            if (nums[i] == 0) {
                zero++;
                swap(nums, i, zero);
                i++;
            } else if (nums[i] == 1) {
                i++;
            } else {
                two--;
                swap(nums, i, two);
            }
        }
    }

    public void sortColors2(int[] nums) {
        // 插入排序
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j > 0; j--) {
                if (nums[j] < nums[j - 1]) {
                    swap(nums, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }

    private void swap(int[] nums, int m, int n) {
        int tmp = nums[m];
        nums[m] = nums[n];
        nums[n] = tmp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{2, 1, 2, 0, 1, 2, 0, 0, 1, 1, 2, 0};

        solution.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
