package leetcode.P0028;

/**
 * 给你两个字符串haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。如果needle 不是 haystack 的一部分，则返回  -1 。
 */
public class Solution {

    public static int strStr(String haystack, String needle) {

        if (needle.length() > haystack.length()) {
            return -1;
        }

        int startIndex = -1;

        // haystack中的偏移，一开始为0
        int offset = 0;
        for (int i = 0; i < needle.length(); ) {

            if (i + offset >= haystack.length()) {
                return -1;
            }

            // 一个字符一个字符开始比较
            char h = haystack.charAt(i + offset);
            char n = needle.charAt(i);

            // 如果两个字符不相同，开始下标要清空
            if (h != n) {
                i = 0;
                startIndex = -1;
                offset++;
                continue;
            } else {
                if (startIndex < 0) {
                    startIndex += offset + 1;
                }
            }
            i++;
        }

        return startIndex;
    }

    public static void main(String[] args) {

        String haystack = "leetcode";
        String needle = "leeto";

        System.out.println(strStr(haystack, needle));
    }
}