package leetcode.P0009;

/**
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * <p>
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * <p>
 */
public class Solution {

    public static boolean isPalindrome(int x) {

        if (x < 0) {
            return false;
        }

        String s = String.valueOf(x);
        int i = 0, j = s.length() - 1;

        while (i <= j) {

            // 两个索引指向同一个字符
            if (i == j) {
                return true;
            }

            if (s.charAt(i) == s.charAt(j)) {
                if (j == (i + 1)) {
                    return true;
                }

                i++;
                j--;
            } else {
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int i0 = 0;
        int i1 = 12;
        int i2 = 12321;
        int i3 = 123452;
        int i4 = 1232112321;
        int i5 = 123212;
        int i6 = 123212;
        int i7 = 123212;
        int i8 = 123212;
        int i9 = 123212;
        System.out.println(i0 + ":" + isPalindrome(i0));
        System.out.println(i1 + ":" + isPalindrome(i1));
        System.out.println(i2 + ":" + isPalindrome(i2));
        System.out.println(i3 + ":" + isPalindrome(i3));
        System.out.println(i4 + ":" + isPalindrome(i4));
        System.out.println(i5 + ":" + isPalindrome(i5));
        System.out.println(i6 + ":" + isPalindrome(i6));
        System.out.println(i7 + ":" + isPalindrome(i7));
        System.out.println(i8 + ":" + isPalindrome(i8));
        System.out.println(i9 + ":" + isPalindrome(i9));
    }
}