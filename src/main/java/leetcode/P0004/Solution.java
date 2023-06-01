package leetcode.P0004;

/**
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 * <p>
 * 提示：
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 *
 * @author xuhq
 * @date 2023/6/1 17:52
 */
public class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int i = 0, j = 0, k = 0;

        int[] merge = new int[nums1.length + nums2.length];
        while (i < nums1.length || j < nums2.length) {
            if (i < nums1.length && j < nums2.length) {
                if (nums1[i] < nums2[j]) {
                    merge[k++] = nums1[i++];
                } else {
                    merge[k++] = nums2[j++];
                }
            } else if (i < nums1.length) { // nums2数组已经结束
                merge[k++] = nums1[i++];
            } else { // nums1数组已经结束
                merge[k++] = nums2[j++];
            }
        }

        // 偶数个数
        if (merge.length % 2 == 0) {
            int mid1 = (merge.length - 1) / 2;
            int mid2 = merge.length / 2;
            return (merge[mid1] + merge[mid2]) / 2.0;
        }

        // 奇数
        return merge[(merge.length - 1) / 2];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = new int[]{1, 2, 3, 4, 5, 6, 7};
        int[] nums2 = new int[]{0, 1, 2, 3};

        System.out.println(solution.findMedianSortedArrays(nums1, nums2));
    }
}
