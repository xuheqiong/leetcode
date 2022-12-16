package leetcode.P0022_hard;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字 n代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 */
public class Solution {

    public static List<String> generateParenthesis(int n) {

//        Set<String> parenthesisSet = new HashSet<>();

        List<String> parenthesisList = new ArrayList<>();
        backtrack(parenthesisList, new StringBuilder(), 0, 0, n);
//        generateParenthesis(n, "", parenthesisSet);

        return new ArrayList<>(parenthesisList);
    }
    public static void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max) {

        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            return;
        }

        if (open < max) {
            cur.append('(');
            backtrack(ans, cur, open + 1, close, max);
            cur.deleteCharAt(cur.length() - 1);
        }

        if (close < open) {
            cur.append(')');
            backtrack(ans, cur, open, close + 1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(2));
    }
}