package leetcode.P0032_unsolved;

import java.util.Stack;

/**
 * 给你一个只包含 '('和 ')'的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 */
public class Solution {

    public static int longestValidParentheses(String s) {
        if (s.length() == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();

        int maxLen = 0;
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ('(' == c) {
                // 将左括号的下标压入栈
                stack.push(i);
            } else if (')' == c) {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {

        String haystack = "(()(()()(())((())()()(";

        System.out.println(longestValidParentheses(haystack));
    }
}