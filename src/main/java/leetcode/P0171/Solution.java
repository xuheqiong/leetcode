package leetcode.P0171;

/**
 * 给你一个字符串columnTitle ，表示 Excel 表格中的列名称。返回 该列名称对应的列序号。
 */
public class Solution {

    public static int titleToNumber(String columnTitle) {

        int num = 0;
        int length = columnTitle.length();
        int[] arr = new int[length];
        for (int i = length - 1; i >= 0; i--) {
            char c = columnTitle.charAt(i);
            int cInt = c - 'A' + 1;
            arr[length - i - 1] = cInt;
        }

        for (int i = 0; i < arr.length; i++) {
            num += arr[i] * Math.pow(26, i);
        }

        return num;
    }

    public static void main(String[] args) {

        System.out.println(titleToNumber("ZY"));
    }
}
