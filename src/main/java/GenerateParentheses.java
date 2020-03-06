import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Harry Liu
 * @version Mar 5, 2020
 * @challenge https://leetcode.com/problems/generate-parentheses
 * @solution Enumerate only valid combinations.
 */
public class GenerateParentheses {
    private static final char LEFT_PAREN = '(';
    private static final char RIGHT_PAREN = ')';

    public List<String> generateParenthesis(int n) {
        List<String> combos = new ArrayList<>();
        if (n < 0) {
            return combos;
        }

        Stack<Character> combo = new Stack<>();
        combo.push(LEFT_PAREN);
        generateParenthesisRec(combos, combo, n - 1, n - 1);
        return combos;
    }

    private void generateParenthesisRec(
            List<String> combos,
            Stack<Character> combo,
            int availLeftParen,
            int availRightParen
    ) {
        if (availLeftParen == 0 && availRightParen == 0) {
            combo.push(RIGHT_PAREN);
            combos.add(toString(combo));
            combo.pop();
            return;
        }

        if (availLeftParen == 0) {
            combo.push(RIGHT_PAREN);
            generateParenthesisRec(combos, combo, availLeftParen, availRightParen - 1);
            combo.pop();
            return;
        }

        if (availRightParen == 0) {
            combo.push(LEFT_PAREN);
            generateParenthesisRec(combos, combo, availLeftParen - 1, availRightParen);
            combo.pop();
            return;
        }

        combo.push(LEFT_PAREN);
        generateParenthesisRec(combos, combo, availLeftParen - 1, availRightParen);
        combo.pop();

        if (availLeftParen > availRightParen) {
            return;
        }

        combo.push(RIGHT_PAREN);
        generateParenthesisRec(combos, combo, availLeftParen, availRightParen - 1);
        combo.pop();
    }

    private String toString(List<Character> chars) {
        StringBuilder builder = new StringBuilder();
        for (char c : chars) {
            builder.append(c);
        }
        return builder.toString();
    }
}
