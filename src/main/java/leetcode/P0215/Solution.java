package leetcode.P0215;

import java.util.Random;

/**
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * 提示：
 * 1 <= k <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * 思路：
 * 双路快速排序算法，找到某个点应该所在的位置，判断是否是该位置，不是则在一端继续寻找。
 * 将原问题化简为第k大的问题
 *
 * @author xuhq
 * @date 2023/6/1 16:17
 */
public class Solution {

    private static final Random RANDOM = new Random();

    public int findKthLargest(int[] nums, int k) {

        int l = nums.length - k;
        return sort(nums, 0, nums.length - 1, l);
    }

    private int sort(int[] arr, int l, int r, int k) {

        int p = partition2(arr, l, r);
        if (p == k) {
            return arr[p];
        }

        if (p > k) {
            return sort(arr, l, p - 1, k);
        }

        return sort(arr, p + 1, r, k);
    }

    /**
     * 双路快速排序
     *
     * @param arr
     * @param l
     * @param r
     * @return
     */
    private int partition2(int[] arr, int l, int r) {
        int p = RANDOM.nextInt(r - l + 1) + l; // bound是开区间，不包含r-l+1
        if (p != l) {
            swap(arr, p, l);
        }

        // 定义：[l+1, i] < v, [j, r] > v, i是当前正在处理的元素的索引
        int i = l + 1, j = r;

        while (true) {
            while (i <= j && arr[i] < arr[l]) {
                i++;
            }

            while (i <= j && arr[j] > arr[l]) {
                j--;
            }

            if (i >= j) {
                break;
            }

            swap(arr, i, j);
            i++;
            j--;
        }

        swap(arr, l, j);
        return j;
    }

    private void swap(int[] nums, int m, int n) {
        int tmp = nums[m];
        nums[m] = nums[n];
        nums[n] = tmp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        int[] nums = new int[]{7, 6, 5, 4, 3, 2, 1};

        System.out.println(solution.findKthLargest(nums, 3));
    }
}
