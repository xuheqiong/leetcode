package leetcode.P0162;

/**
 * 峰值元素是指其值严格大于左右相邻值的元素。
 * 给你一个整数数组nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
 * 你可以假设nums[-1] = nums[n] = -∞ 。
 * 你必须实现时间复杂度为 O(log n) 的算法来解决此问题。
 */
public class Solution {

    public static int findPeakElement(int[] nums) {

        return findPeakElement(nums, 0, nums.length - 1);
    }

    public static int findPeakElement(int[] nums, int start, int end) {

        if (start > end) {
            return -1;
        }

        if (start == end) {
            return start;
        }

        if (end - start == 1) {
            if (nums[end] > nums[start]) {
                return end;
            }
            return start;
        }

        int mid = (start + end) / 2;
        int midVal = nums[mid];
        int leftVal = nums[mid - 1];
        int rightVal = nums[mid + 1];

        // 中间值比左右两边都大，说明找到峰值了
        if (midVal > leftVal && midVal > rightVal) {
            return mid;
        }

        // 如果中间的值》 左边的值，说明峰值在右边
        if (midVal > leftVal) {
            return findPeakElement(nums, mid, end);
        }
        return findPeakElement(nums, start, mid);
    }


    public static void main(String[] args) {

        int[] nums = {1, 2, 1, 3, 5, 6, 7,8};
        System.out.println(findPeakElement(nums));
    }
}
