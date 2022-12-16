package leetcode.P0046;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 */
public class Solution {

    public static List<List<Integer>> permute(int[] nums) {

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

        // 当前已经进行到最后一层了,那么可以结束递归,直接返回
        if (depth == nums.length) {
            ret.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 如果这个值还没被用过, 在这个值的基础上继续递归
            if (!used[i]) {
                path.addLast(nums[i]);
                used[i] = true;
                dfs(nums, depth + 1, path, used, ret);

                // 回溯
                used[i] = false;
                path.removeLast();
            }
        }
    }

    public static void main(String[] args) {

        int[] nums = new int[]{1, 2, 3, 4};
        System.out.println(permute(nums));
    }
}