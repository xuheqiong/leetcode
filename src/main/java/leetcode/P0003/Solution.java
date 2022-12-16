package leetcode.P0003;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的最长子串的长度。
 */
public class Solution {
    public static int lengthOfLongestSubstring(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }

        int maxLen = 0;
        int len = 0;
        int headIndex = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // 如果c不在set中，说明还没有重复的字符
            if (!map.containsKey(c)) {
                len++;
            } else {
                // 如果c已经在set中，计算下偏移量
                int lastIndex = map.get(c);
                if(lastIndex > headIndex ) {
                    headIndex = lastIndex;
                }
                len = i - headIndex;
            }
            // 更新下最新的索引
            map.put(c, i);

            maxLen = Math.max(maxLen, len);
        }

        return maxLen;
    }

    public static void main(String[] args) {

        String s = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s));
    }
}