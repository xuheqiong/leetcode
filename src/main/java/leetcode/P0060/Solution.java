package leetcode.P0060;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出集合[1,2,3,...,n]，其所有元素共有n! 种排列。
 * 给定n 和k，返回第k个排列。
 * <p>
 * 思路：深度优先遍历
 */
public class Solution {

    public String getPermutation(int n, int k) {

        int[] arr = new int[n];
        boolean[] used = new boolean[n];
        for (int i = 1; i <= n; i++) {
            arr[i - 1] = i;
        }

        List<String> paths = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        dfs(arr, 0, path, k, paths, used);

        return paths.get(k - 1);
    }

    private void dfs(int[] nums,
                     int depth,
                     StringBuilder path,
                     int k,
                     List<String> allPaths,
                     boolean[] used) {

        // 已经到达最深后的
        if (depth == nums.length) {
            System.out.println("----执行第" + allPaths.size() + "次，path=" + path);
            allPaths.add(path.toString());
            return;
        }


        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                path.append(nums[i]);

                dfs(nums, depth + 1, path, k, allPaths, used);

                if ((depth + 1 == nums.length) && allPaths.size() == k) {
                    return;
                }

                // 回溯
                used[i] = false;
                path.deleteCharAt(path.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.getPermutation(4, 5));
    }
}
