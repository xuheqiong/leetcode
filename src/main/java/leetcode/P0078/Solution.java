package leetcode.P0078;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 100
 * nums 中的所有元素 互不相同
 *
 * @author xuhq
 * @date 2023/5/23 15:10
 */
public class Solution {


    public static List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> ret = new ArrayList<>();
        Set<Integer> indexSet = new HashSet<>();
        dfs(ret, indexSet, 0, nums);

        return ret;
    }

    private static void dfs(List<List<Integer>> ret, Set<Integer> numSet, int cur, int[] nums) {

        if (cur == nums.length) {
            ret.add(new ArrayList<>(numSet));
            return;
        }

        numSet.add(nums[cur]);
        dfs(ret, numSet, cur + 1, nums);

        numSet.remove(nums[cur]);
        dfs(ret, numSet, cur + 1, nums);
    }

    public static List<List<Integer>> subsets2(int[] nums) {

        List<List<Integer>> ret = new ArrayList<>();

        for (int mask = 0; mask < (1 << nums.length); mask++) {
            List<Integer> t = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                if ((mask & (1 << i)) != 0) {
                    t.add(nums[i]);
                }
            }
            ret.add(t);
        }

        return ret;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 5, 6};

        System.out.println(subsets(nums));
    }
}
