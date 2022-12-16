package leetcode.P0056;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 * 提示：
 * 1 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 104
 * <p>
 * 思路：两两合并
 */
public class Solution {

    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));

        int[] first = intervals[0];

        List<int[]> newIntervals = new ArrayList<>();
        for (int i = 1; i < intervals.length; i++) {
            int[] second = intervals[i];
            first = mergeTwo(first, second, newIntervals);
        }
        newIntervals.add(first);

        int[][] ret = new int[newIntervals.size()][];
        for (int i = 0; i < newIntervals.size(); i++) {
            ret[i] = newIntervals.get(i);
        }
        return ret;
    }

    /**
     * 返回的是下一次要合并的数组
     *
     * @param arr1
     * @param arr2
     * @param newIntervals
     * @return
     */
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
        int[][] intervals = new int[][]{{1, 4}, {0, 4}, {9, 10}, {5, 6}, {1, 3}, {0, 9}};

        Solution solution = new Solution();
        System.out.println(Arrays.deepToString(solution.merge(intervals)));
    }
}