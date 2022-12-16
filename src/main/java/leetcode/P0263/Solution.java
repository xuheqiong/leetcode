package leetcode.P0263;

import java.util.ArrayList;
import java.util.List;

/**
 * 丑数 就是只包含质因数2、3 和 5的正整数。
 * 给你一个整数 n ，请你判断 n 是否为 丑数 。如果是，返回 true ；否则，返回 false 。
 *
 * @author xuhq
 * @date 2022/12/13 22:26
 */
public class Solution {

    public boolean isUgly(int n) {

        List<Integer> factors = new ArrayList<>();
        factors.add(2);
        factors.add(3);
        factors.add(5);

        for (int i = 0; i < factors.size(); i++) {
            int factor = factors.get(i);
            while (n > 0) {
                int r = n % factor;
                // 说明是倍数
                if (r == 0) {
                    n = n / factor;
                } else {
                    // 拿下一个因数
                    break;
                }
            }
        }

        return n == 1;
    }

    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(solution.isUgly(8)); // 20 = 2*2*5，是丑数
        System.out.println(solution.isUgly(18)); // 20 = 2*2*5，是丑数
        System.out.println(solution.isUgly(80)); // 20 = 2*2*5，是丑数
        System.out.println(solution.isUgly(888)); // 20 = 2*2*5，是丑数
        System.out.println(solution.isUgly(1)); // 20 = 2*2*5，是丑数
    }
}
