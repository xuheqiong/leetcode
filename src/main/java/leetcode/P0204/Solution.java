package leetcode.P0204;

/**
 * 给定整数 n ，返回 所有小于非负整数n的质数的数量 。
 * 思路：埃氏筛
 */
public class Solution {

    public static int countPrimes(int n) {

        if (n == 0 || n == 1) {
            return 0;
        }

        // 记下每个数是否是质数
        boolean[] isPrime = new boolean[n];
        for (int i = 0; i < n; i++) {
            // 默认所有数据都是质数
            isPrime[i] = true;
        }

        isPrime[0] = false;
        isPrime[1] = false;

        int primeCount = 0;
        for (int i = 2; i < n; i++) {
            // 如果i是质数，那么i的倍数肯定不是质数
            if (isPrime[i]) {
                primeCount++;
                //  j < (n + i - 1) / i，这步是为了避免整数除法导致精度不准的问题
                for (int j = i; j < (n + i - 1) / i; j++) {
                    isPrime[i * j] = false;
                }
            }
        }

        return primeCount;
    }

    public static void main(String[] args) {
        System.out.println(countPrimes(499979));
    }
}