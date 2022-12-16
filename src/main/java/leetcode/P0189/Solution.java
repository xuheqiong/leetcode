package leetcode.P0189;

/**
 * 给你一个数组，将数组中的元素向右轮转 k个位置，其中k是非负数。
 */
public class Solution {

    public static void rotate(int[] nums, int k) {

        if (k == 0) {
            return;
        }
        if (nums.length == 1) {
            return;
        }

        int[] tmp = new int[nums.length];

        int length = nums.length;
        // 实际需要移动的次数
        k = k % length;
        for (int i = 0; i < length; i++) {
            tmp[i] = nums[(i - k + length) % length];
        }

        for (int i = 0; i < length; i++) {
            nums[i] = tmp[i];
        }
    }

    public static void main(String[] args) {

        int[] nums = new int[]{1, 2, 3, 4, 5};
        rotate(nums, 1);

        for (int num : nums) {
            System.out.println(num);
        }
    }
}