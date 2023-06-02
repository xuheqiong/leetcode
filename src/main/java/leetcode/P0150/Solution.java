package leetcode.P0150;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给你一个字符串数组 tokens ，表示一个根据 逆波兰表示法 表示的算术表达式。
 * 请你计算该表达式。返回一个表示表达式值的整数。
 * <p>
 * 注意：
 * 有效的算符为 '+'、'-'、'*' 和 '/' 。
 * 每个操作数（运算对象）都可以是一个整数或者另一个表达式。
 * 两个整数之间的除法总是 向零截断 。
 * 表达式中不含除零运算。
 * 输入是一个根据逆波兰表示法表示的算术表达式。
 * 答案及所有中间计算结果可以用 32 位 整数表示。
 * <p>
 * 思路：用栈操作运算：遇到数字则入栈；遇到算符则取出栈顶两个数字进行计算，并将结果压入栈中
 *
 * @author xuhq
 * @date 2023/6/2 15:15
 */
public class Solution {

    public int evalRPN(String[] tokens) {

        Deque<String> nums = new LinkedList<>();

        for (String token : tokens) {

            // 如果是符号，出栈两个数据，将计算结果再入栈
            if ("+".equals(token)) {
                int num1 = Integer.parseInt(nums.pop());
                int num2 = Integer.parseInt(nums.pop());
                nums.push(String.valueOf(num2 + num1));
            } else if ("-".equals(token)) {
                int num1 = Integer.parseInt(nums.pop());
                int num2 = Integer.parseInt(nums.pop());
                nums.push(String.valueOf(num2 - num1));
            } else if ("*".equals(token)) {
                int num1 = Integer.parseInt(nums.pop());
                int num2 = Integer.parseInt(nums.pop());
                nums.push(String.valueOf(num2 * num1));
            } else if ("/".equals(token)) {
                int num1 = Integer.parseInt(nums.pop());
                int num2 = Integer.parseInt(nums.pop());
                nums.push(String.valueOf(num2 / num1));
            } else {
                nums.push(token);
            }
        }

        return Integer.parseInt(nums.pop());
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] token = new String[]{"4", "13", "5", "/", "+"};
        System.out.println(solution.evalRPN(token));
    }
}