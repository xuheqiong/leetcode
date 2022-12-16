package leetcode.P0047_unsolved;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * TODO
 * <p>
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列
 */
public class Solution {

    public static List<List<Integer>> permuteUnique(int[] nums) {

        List<List<Integer>> ret = new ArrayList<>();

        Deque<Integer> path = new ArrayDeque<>();
        boolean[] used = new boolean[nums.length];
        dfs(nums, 0, path, used, ret);

        return ret;
    }

    /**
     * 深度优先遍历
     *
     * @param nums  从顶层传来的数组
     * @param depth 当前进行到第几层
     * @param ret   最终结果
     */
    private static void dfs(int[] nums, int depth, Deque<Integer> path, boolean[] used, List<List<Integer>> ret) {

        // 当前已经进行到最后一层了,那么可以结束递归,直接返回[
        if (depth == nums.length) {
            ret.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (used[i] || (i > 0 && (nums[i] == nums[i - 1]) && !used[nums[i - 1]])) {
                continue;
            }

            // 如果这个值还没被用过, 在这个值的基础上继续递归
            if (!used[i]) {
                path.addLast(nums[i]);
                used[i] = true;
                dfs(nums, depth + 1, path, used, ret);

                // 回溯
                path.removeLast();
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {

        int[] nums = new int[]{1, 1, 3};
        System.out.println(permuteUnique(nums));
    }
}