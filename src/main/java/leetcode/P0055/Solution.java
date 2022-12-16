package leetcode.P0055;

/**
 * 给定一个非负整数数组nums ，你最初位于数组的 第一个下标 。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标。
 * 提示：
 * 1 <= nums.length <= 3 * 104
 * 0 <= nums[i] <= 105
 *
 * <p>
 * 思路：遍历所有节点，看能跳得最远的位置是否不小于数组长度-1
 */
public class Solution {
    public boolean canJump(int[] nums) {
        // 表示能跳的最远的索引
        int maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            // 如果已经超过最后一个节点了，说明可以到达
            if (maxIndex >= nums.length - 1) {
                return true;
            }

            // 如果当前索引的值 > 0，说明可以继续往后跳，计算下能跳到的最大索引
            if (nums[i] > 0) {
                maxIndex = Math.max(maxIndex, i + nums[i]);
            } else {
                // 如果当前位置的值是0，说明在当前位置不能跳，
                // 比较下当前位置和能跳的最大位置
                if (i >= maxIndex) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{3, 0, 8, 2, 0, 0, 1};
        System.out.println(solution.canJump(nums));
    }
}

