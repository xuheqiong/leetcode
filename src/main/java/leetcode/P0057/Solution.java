package leetcode.P0057;

import java.util.ArrayList;
import java.util.Arrays;
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
 * <p>
 * 思路：先生成一个比原数组多一个长度的新数组，将原数组和新数组合并，再根据P0056的思路合并区间
 * 分析：时间复杂度O(n)，空间复杂度O(n)
 */
public class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        if (intervals.length == 0) {
            return new int[][]{newInterval};
        }

        boolean needCompare = true;
        int[][] newInts = new int[intervals.length + 1][2];
        for (int i = 0; i < newInts.length; i++) {
            if (needCompare) {
                // 已经超过原数组了还要比较，说明新区间在最后
                if (i == newInts.length - 1) {
                    newInts[i] = newInterval;
                } else {
                    if (newInterval[0] < intervals[i][0]) {
                        newInts[i] = newInterval;
                        needCompare = false;
                    } else {
                        newInts[i] = intervals[i];
                    }
                }
            } else {
                newInts[i] = intervals[i - 1];
            }
        }

        // 合并区间
        int[] first = newInts[0];

        List<int[]> newIntervals = new ArrayList<>();
        for (int i = 1; i < newInts.length; i++) {
            int[] second = newInts[i];
            first = mergeTwo(first, second, newIntervals);
        }
        newIntervals.add(first);

        int[][] ret = new int[newIntervals.size()][];
        for (int i = 0; i < newIntervals.size(); i++) {
            ret[i] = newIntervals.get(i);
        }

        return ret;
    }

    private int[] mergeTwo(int[] arr1, int[] arr2, List<int[]> newIntervals) {
        int[] arr3 = new int[2];

        // 比较下arr1和arr2
        if (arr1[0] > arr2[0]) {
            int[] tmp = arr1;
            arr1 = arr2;
            arr2 = tmp;
        }

        // left1 < left2
        int left1 = arr1[0];
        int right1 = arr1[1];

        int left2 = arr2[0];
        int right2 = arr2[1];

        // 如果两个区间有交集
        if (right1 >= left2) {
            arr3[0] = left1;
            arr3[1] = Math.max(right1, right2);
            return arr3;
        }

        // 两个区间没交集
        newIntervals.add(arr1);
        return arr2;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] intervals = new int[][]{{1, 5}};
        int[] newInterval = new int[]{0, 3};
        System.out.println(Arrays.deepToString(solution.insert(intervals, newInterval)));
    }
}