package leetcode.P0058;

/**
 * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
 * <p>
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
 */
public class Solution {
    public static int lengthOfLastWord(String s) {

        int i, j;
        i = j = s.length() - 1;
        while (i >= 0) {

            if (s.charAt(i) == ' ') {
                if (i != j) {
                    break;
                }
                j--;
            } else {
                // 如果s.charAt(i)不为空，说明已经到了最后一个单词的词尾，j就不要动了
                // i继续往前挪
            }
            i--;
        }
        return j - i;
    }

    public static void main(String[] args) {

        String s = "   fly me   to   the moon  ";
        System.out.println(lengthOfLastWord(s));
    }
}