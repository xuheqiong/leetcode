package leetcode.P0740;

/**
 * 给你一个整数数组 nums ，你可以对它进行一些操作。
 * 每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。之后，你必须删除 所有 等于 nums[i] - 1 和 nums[i] + 1 的元素。
 * 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。
 * <p>
 * 思路&分析：
 * 在选择了元素 xx后，该元素以及所有等于 x−1 或 x+1的元素会从数组中删去。若还有多个值为 xx 的元素，由于所有等于 x−1 或 x+1 的元素已经被删除，我们可以直接删除 xx 并获得其点数。因此若选择了 xx，所有等于 xx 的元素也应一同被选择，以尽可能多地获得点数。
 * 所以只能一个间隔一个选元素，在这种情况下计算最大值
 *
 * @author xuhq
 * @date 2023/6/7 17:18
 */
public class Solution {
    public int deleteAndEarn(int[] nums) {

        int maxVal = 0;
        for (int val : nums) {
            maxVal = Math.max(maxVal, val);
        }
        int[] sum = new int[maxVal + 1];
        for (int val : nums) {
            // 这样子得出的数组天生就是排序的
            sum[val] += val;
        }

        return rob(sum);
    }

    public int rob(int[] nums) {
        int size = nums.length;
        int first = nums[0], second = Math.max(nums[0], nums[1]);
        for (int i = 2; i < size; i++) {
            int temp = Math.max(first + nums[i], second);
            first = second;
            second = temp;
        }
        return second;
    }
}
