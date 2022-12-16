package leetcode.P0151;

import java.util.Stack;

/**
 * 给你一个字符串 s ，请你反转字符串中 单词 的顺序。
 * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
 * 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
 * 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
 * <p>
 * 思路：用栈
 */
public class Solution {

    public static String reverseWords(String s) {

        Stack<String> stack = new Stack<>();

        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);

            // 如果是前导空格，直接忽略
            if (c == ' ' && stack.isEmpty()) {
                continue;
            }

            // 如果c是空格，且栈中已经有空格了，也忽略
            if (c == ' ' && " ".equals(stack.peek())) {
                continue;
            } else if (c == ' ' && !" ".equals(stack.peek())) {
                // 如果c是空格，且栈中第一个元素不是空格，把空格压入栈
                stack.push(String.valueOf(c));
            } else if (c != ' ') {
                // c不是空格
                // 栈中为空，表示是第一个非空字符
                if (stack.isEmpty()) {
                    stack.push(String.valueOf(c));
                } else {
                    // 栈不为空，表明栈中之前就有值，判断下栈顶元素是不是空格，是空格，直接入栈；不是空格，把栈顶元素取出，将当前的字符拼上去在压入栈
                    if (" ".equals(stack.peek())) {
                        stack.push(String.valueOf(c));
                    } else {
                        String value = stack.pop();
                        value = value + c;
                        stack.push(value);
                    }
                }
            }
        }

        // 把栈顶的空格弹出去
        if (" ".equals(stack.peek())) {
            stack.pop();
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        String s = "  hello world  ";
        String s1 = "a good   example";

        System.out.println(reverseWords(s));
        System.out.println(reverseWords(s1));
    }
}
