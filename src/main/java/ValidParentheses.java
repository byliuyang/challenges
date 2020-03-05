import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author Harry Liu
 * @version Mar 4, 2020
 * @challenge https://leetcode.com/problems/valid-parentheses
 * @solution Memorize open parenthesises using stack.
 */
public class ValidParentheses {
    private static Map<Character, Character> openParens;

    static {
        openParens = new HashMap<>();
        openParens.put(')', '(');
        openParens.put(']', '[');
        openParens.put('}', '{');
    }

    public boolean isValid(String s) {
        if (s == null) {
            return true;
        }

        int strLen = s.length();
        if (isOdd(strLen)) {
            return false;
        }

        Stack<Character> leftParenSeen = new Stack<>();

        char[] chars = s.toCharArray();
        for (char paren : chars) {
            if (!openParens.containsKey(paren)) {
                leftParenSeen.push(paren);
                continue;
            }

            if (leftParenSeen.size() < 1) {
                return false;
            }

            char gotParen = leftParenSeen.pop();
            char expectedParen = openParens.get(paren);
            if (expectedParen != gotParen) {
                return false;
            }
        }
        return leftParenSeen.size() == 0;
    }

    private boolean isOdd(int num) {
        return num % 2 != 0;
    }
}
