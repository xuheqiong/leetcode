package leetcode.P0080;

/**
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * 1 <= nums.length <= 3 * 104
 * -104 <= nums[i] <= 104
 * nums 已按升序排列
 *
 * @author xuhq
 * @date 2023/5/25 16:39
 */
public class Solution {

    public int removeDuplicates(int[] nums) {

        // 索引i的元素的个数
        int counti = 1;

        // 表示可覆盖的索引位置，要从这个索引位置开始覆盖
        int overrideIndex = -1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) {
                counti++;

                if (counti > 2) {
                    // 超过部分不复制
                    if (overrideIndex == -1) {
                        overrideIndex = i;
                    }
                } else {
                    // 不超过2个的部分要复制
                    if (overrideIndex != -1) {
                        nums[overrideIndex++] = nums[i];
                    }
                }
            } else {
                // 转折点也要复制
                if (overrideIndex != -1) {
                    nums[overrideIndex++] = nums[i];
                }
                // 重置counti
                counti = 1;
            }
        }

        return overrideIndex == -1 ? nums.length : overrideIndex;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{1, 1, 1, 2, 2, 2, 3, 4, 4, 4};
//        int[] nums = new int[]{1, 1};
//        int[] nums = new int[]{1};
//        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] nums = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1};

        Solution solution = new Solution();
        int n = solution.removeDuplicates(nums);
        System.out.println(n);

        for (int i = 0; i < n; i++) {
            System.out.print(nums[i] + ",");
        }
    }
}
