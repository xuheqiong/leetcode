package leetcode.P0079;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 * @author xuhq
 * @date 2023/5/24 13:05
 */
public class Solution {

    /**
     * 四个方向
     */
    private final int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public boolean exist(char[][] board, String word) {

        char[] words = word.toCharArray();

        int row = board.length;
        int col = board[0].length;
        boolean[][] visited = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                Deque<Character> queue = new LinkedList<>();
                if (findWay(board, words, 0, i, j, visited, queue)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean findWay(char[][] board, char[] words, int cur, int row, int col, boolean[][] visited, Deque<Character> deque) {

        boolean result = false;

        if (board[row][col] != words[cur]) {
            return false;
        }

        // 如果当前位置是我们要找的字符，加入队列中，并继续下一个位置
        deque.add(words[cur]);

        // 设置访问标记位
        visited[row][col] = true;

        if (deque.size() == words.length && cur == words.length - 1) {
            return true;
        }

        for (int[] direction : directions) {

            int newRow = row + direction[0];
            int newCol = col + direction[1];

            // 索引没有越界，且当前位置没有被访问过
            if (newRow >= 0 && newRow < board.length && newCol >= 0 && newCol < board[0].length && !visited[newRow][newCol]) {
                if (findWay(board, words, cur + 1, newRow, newCol, visited, deque)) {
                    result = true;
                    break;
                }
            }
        }
        // 这步很关键，需要回退
        visited[row][col] = false;
        deque.pop();

        return result;
    }

    public static void main(String[] args) {
//        char[][] board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
//        char[][] board = new char[][]{{'a', 'a', 'a', 'a'}, {'a', 'a', 'a', 'a'}, {'a', 'a', 'a', 'a'}};
//        char[][] board = new char[][]{{'A'}};

        char[][] board = new char[][]{{'C', 'A', 'A'}, {'A', 'A', 'A'}, {'B', 'C', 'D'}};

        String word = "AAB";

        Solution solution = new Solution();
        System.out.println(solution.exist(board, word));
    }
}
