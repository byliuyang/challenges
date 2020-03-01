import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author Harry Liu
 * @version Mar 1, 2020
 * @challenge https://leetcode.com/problems/letter-combinations-of-a-phone-number
 * @solution Recursively loop through all the letter combinations.
 */
public class TelephoneKeypad {
    public List<String> letterCombinations(String digits) {
        List<String> combinations = new LinkedList<>();

        if (digits == null) {
            return combinations;
        }

        int numDigits = digits.length();
        if (numDigits < 1) {
            return combinations;
        }

        String[] digitToLetters = new String[]{
                null,
                null,
                "abc",
                "def",
                "ghi",
                "jkl",
                "mno",
                "pqrs",
                "tuv",
                "wxyz"
        };
        Stack<Character> selectedLetters = new Stack<>();
        generateCombinations(digitToLetters, digits, combinations, selectedLetters, 0, numDigits);
        return combinations;
    }

    private void generateCombinations(
            String[] digitToLetters,
            String digits,
            List<String> combinations,
            Stack<Character> selectedLetters,
            int currDigitIdx,
            int numDigits
    ) {
        if (currDigitIdx >= numDigits) {
            String combination = toString(selectedLetters);
            combinations.add(combination);
            return;
        }

        int digit = digits.charAt(currDigitIdx) - '0';
        char[] letters = digitToLetters[digit].toCharArray();
        for (char letter : letters) {
            selectedLetters.push(letter);
            generateCombinations(digitToLetters, digits, combinations, selectedLetters, currDigitIdx + 1, numDigits);
            selectedLetters.pop();
        }
    }

    private String toString(Stack<Character> selectedLetters) {
        StringBuilder builder = new StringBuilder();
        for (char letter : selectedLetters) {
            builder.append(letter);
        }
        return builder.toString();
    }
}
