package leetcode.P0034;

import java.util.Arrays;

/**
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回[-1, -1]。
 * 你必须设计并实现时间复杂度为O(log n)的算法解决此问题。
 */
public class Solution {

    public static int[] searchRange(int[] nums, int target) {

        if (nums.length == 0) {
            return new int[]{-1, -1};
        }

        int mid = (nums.length - 1) / 2;

        // [0, mid]中符合条件的索引
        int[] left = searchRange(nums, 0, mid, target);
        // [mid +1, nums.length - 1]中符合条件的索引
        int[] right = searchRange(nums, mid + 1, nums.length - 1, target);

        // 左边都不符合
        if (left[0] == -1 && left[1] == -1) {
            return right;
        }

        if (right[0] == -1 && right[1] == -1) {
            return left;
        }

        int[] ret = new int[2];
        ret[0] = left[0];
        ret[1] = right[1];

        return ret;
    }


    private static int[] searchRange(int[] nums, int start, int end, int target) {

        // 如果start > end，说明没找到符合条件的，结束了
        if (start > end) {
            return new int[]{-1, -1};
        }

        if (start == end) {
            if (nums[start] == target) {
                return new int[]{start, end};
            } else {
                return new int[]{-1, -1};
            }
        }

        // start < end
        // 如果最大的那个数比target还要小，或者最小的数比target还要大，说明在这个区间里没有需要的数据
        if (nums[start] > target || nums[end] < target) {
            return new int[]{-1, -1};
        }

        // target在区间内
        if (nums[start] < target && nums[end] > target) {
            int mid = (start + end) / 2;
            int[] left = searchRange(nums, start, mid, target);
            int[] right = searchRange(nums, mid + 1, end, target);

            // 左边都不符合
            if (left[0] == -1 && left[1] == -1) {
                return right;
            }
            if (right[0] == -1 && right[1] == -1) {
                return left;
            }
            int[] ret = new int[2];
            ret[0] = left[0];
            ret[1] = right[1];
            return ret;
        }

        int[] ret = new int[]{-1, -1};
        if (nums[start] == target && nums[end] == target) {
            ret[0] = start;
            ret[1] = end;
        } else if (nums[start] == target && nums[end] > target) {
            ret[0] = start;

            int mid = (start + 1 + end) / 2;
            int[] left = searchRange(nums, start + 1, mid, target);
            int[] right = searchRange(nums, mid + 1, end, target);

            // 左边都不符合
            if (left[0] == -1 && left[1] == -1 && right[0] == -1 && right[1] == -1) {
                ret[1] = ret[0];
                return ret;
            }

            if (right[0] != -1 && right[1] != -1) {
                ret[1] = right[1];
                return ret;
            }
            ret[1] = left[1];
        } else if (nums[start] < target && nums[end] == target) {
            ret[1] = end;

            int mid = (start + end - 1) / 2;
            int[] left = searchRange(nums, start, mid, target);
            int[] right = searchRange(nums, mid + 1, end - 1, target);

            // 左边都不符合
            if (left[0] == -1 && left[1] == -1 && right[0] == -1 && right[1] == -1) {
                ret[0] = ret[1];
                return ret;
            }

            if (left[0] != -1 && left[1] != -1) {
                ret[0] = left[0];
                return ret;
            }
            ret[0] = right[0];
        }

        return ret;
    }

    public static void main(String[] args) {

        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        System.out.println(Arrays.toString(searchRange(nums, 9)));

    }
}