package leetcode.P0057_unsolved;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个 无重叠的 ，按照区间起始端点排序的区间列表。
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 * 提示：
 * 0 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <=intervals[i][0] <=intervals[i][1] <= 105
 * intervals 根据 intervals[i][0] 按 升序 排列
 * newInterval.length == 2
 * 0 <=newInterval[0] <=newInterval[1] <= 105
 */
public class Solution {
    public static int[][] insert(int[][] intervals, int[] newInterval) {

        if (intervals.length == 0) {
            return new int[][]{newInterval};
        }

        return new int[][]{};
    }

    private static int[][] binarySearch(int[][] intervals, int[] newInterval, int start, int end) {

        if (start > end) {
            return null;
        }

        List<int[]> newRange = new ArrayList<>();

        if (start == end) {
            int[] arr = intervals[start];
            // 左值
            int left = arr[0];
            // 右值
            int right = arr[1];

            int newLeft = newInterval[0];
            int newRight = newInterval[1];
            int mid = (start + end) / 2;
            // 如果newInterval在左边
            if (newRight < left) {
                binarySearch(intervals, newInterval, start, mid);
            } else if (newLeft > right) {
                binarySearch(intervals, newInterval, mid + 1, end);
            } else {
                newRange.add(new int[]{Math.min(left, newLeft), Math.max(right, newRight)});
            }
        }
        return new int[][]{};
    }


    public static void main(String[] args) {

    }
}