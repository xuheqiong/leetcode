package leetcode.P0205;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个字符串s和t，判断它们是否是同构的。
 * 如果s中的字符可以按某种映射关系替换得到t，那么这两个字符串是同构的。
 * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
 * 思路：双映射
 */
public class Solution {

    public static boolean isIsomorphic(String s, String t) {

        Map<Character, Character> mapst = new HashMap<>();
        Map<Character, Character> mapts = new HashMap<>();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            // 如果还没建立映射关系，建立一下
            if (mapst.get(sc) == null) {
                mapst.put(sc, tc);
            } else {
                // sc之前已有映射关系，判断下map中的值和tc
                Character mapc = mapst.get(sc);
                if (tc != mapc) {
                    return false;
                }
            }
        }

        for (int i = 0; i < length; i++) {
            char tc = t.charAt(i);
            char sc = s.charAt(i);
            // 如果还没建立映射关系，建立一下
            if (mapts.get(tc) == null) {
                mapts.put(tc, sc);
            } else {
                // sc之前已有映射关系，判断下map中的值和tc
                Character mapc = mapts.get(tc);
                if (sc != mapc) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isIsomorphic("agg", "cdd"));
    }
}