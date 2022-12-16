package leetcode.P1832;

import java.util.HashSet;
import java.util.Set;

/**
 * TODO
 *
 * @author user
 * @date 2022/12/13 14:22
 */
public class Solution {

    public boolean checkIfPangram(String sentence) {
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < sentence.length(); i++) {
            set.add(sentence.charAt(i));
        }

        return set.size() >= 26;
    }
}
