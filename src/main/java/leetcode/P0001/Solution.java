package leetcode.P0001;

import java.util.*;

/**
 * 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那两个整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 * <p>
 * 提示：
 * 2 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * 只会存在一个有效答案
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {

        int[] ret = new int[]{-1, -1};
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            List<Integer> indexs = map.get(nums[i]);
            if (indexs == null) {
                indexs = new ArrayList<>();
            }
            indexs.add(i);
            map.put(nums[i], indexs);
        }

        for (int i = 0; i < nums.length; i++) {
            int remaining = target - nums[i];
            List<Integer> indexs = map.get(remaining);

            if (indexs != null && indexs.size() > 0) {
                if (remaining != nums[i]) {
                    ret[0] = i;
                    for (int index : indexs) {
                        if (index != i) {
                            ret[1] = index;
                            break;
                        }
                    }
                    break;
                } else {
                    // remaining == nums[i]
                    if (indexs.size() > 1) {
                        ret[0] = indexs.get(0);
                        ret[1] = indexs.get(1);
                    }
                }
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{3, 2, 4};
        System.out.println(Arrays.toString(solution.twoSum(nums, 6)));
    }
}
