package leetcode.P1684;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * 给你一个由不同字符组成的字符串 allowed 和一个字符串数组 words 。如果一个字符串的每一个字符都在 allowed 中，就称这个字符串是 一致字符串 。
 * <p>
 * 请你返回 words 数组中 一致字符串 的数目。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/count-the-number-of-consistent-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author user
 * @date 2022/11/8 16:52
 */
public class Solution {

    public static int countConsistentStrings(String allowed, String[] words) {

        Set<Character> allowedCharSet = new HashSet<>();

        for (int i = 0; i < allowed.length(); i++) {
            allowedCharSet.add(allowed.charAt(i));
        }

        int ret = 0;

        for (String word : words) {
            Set<Character> wordSet = new HashSet<>();

            for (int i = 0; i < word.length(); i++) {
                wordSet.add(word.charAt(i));
            }

            if (allFits(allowedCharSet, wordSet)) {
                ret++;
            }
        }

        return ret;
    }

    private static boolean allFits(Set<Character> allowedCharSet, Set<Character> wordSet) {

        for (Character c : wordSet) {
            if (!allowedCharSet.contains(c)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        String allowed = "ab";
        String[] words = new String[]{"ad", "bd", "aaab", "baa", "badab"};

        int i = countConsistentStrings(allowed, words);

        System.out.println(i);
    }
}
