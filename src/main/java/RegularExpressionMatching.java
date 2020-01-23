/**
 * @author Harry Liu
 * @version Jan 21, 2020
 *
 * @challenge https://leetcode.com/problems/regular-expression-matching
 * @solution Skip the right number of chars for both of the input string and the pattern.
 * Memorize previously computed results.
 */

public class RegularExpressionMatching {
    private static final char ANY_CHAR = '.';
    private static final char ZERO_OR_MORE = '*';

    public boolean isMatch(String text, String pattern) {
        if (text == null && pattern == null) {
            return true;
        }

        if (text == null || pattern == null) {
            return false;
        }

        int textLen = text.length();
        int patternLen = pattern.length();
        boolean[][] computed = new boolean[textLen + 1][patternLen + 1];
        boolean[][] mem = new boolean[textLen + 1][patternLen + 1];
        return isMatchRec(computed, mem, text, 0, textLen, pattern, 0, patternLen);
    }

    private boolean isMatchRec(
            boolean[][] computed,
            boolean[][] mem,
            String text,
            int textStartAt,
            int textLen,
            String pattern,
            int patternStartAt,
            int patternLen
    ) {
        if (computed[textStartAt][patternStartAt]) {
            return mem[textStartAt][patternStartAt];
        }

        if (hasNoCharLeft(patternStartAt, patternLen)) {
            boolean res = hasNoCharLeft(textStartAt, textLen);
            return memorize(computed, mem, textStartAt, patternStartAt, res);
        }

        if (hasOneCharLeft(patternStartAt, patternLen)) {
            boolean res = hasOneCharLeft(textStartAt, textLen)
                    && isSingleCharMatch(text, textStartAt, textLen, pattern, patternStartAt, patternLen);
            return memorize(computed, mem, textStartAt, patternStartAt, res);
        }

        char patternNextChar = pattern.charAt(patternStartAt + 1);

        if (patternNextChar != ZERO_OR_MORE) {
            if (!isSingleCharMatch(text, textStartAt, textLen, pattern, patternStartAt, patternLen)) {
                return memorize(computed, mem, textStartAt, patternStartAt, false);
            }
            boolean res = matchNextCharAndPattern(
                    computed, mem, text, textStartAt, textLen, pattern, patternStartAt, patternLen);
            return memorize(computed, mem, textStartAt, patternStartAt, res);
        }

        if (hasNoCharLeft(textStartAt, textLen)) {
            boolean res = skipZeroOrMoreMatcher(
                    computed, mem, text, textStartAt, textLen, pattern, patternStartAt, patternLen);
            return memorize(computed, mem, textStartAt, patternStartAt, res);
        }

        if (!isSingleCharMatch(text, textStartAt, textLen, pattern, patternStartAt, patternLen)) {
            boolean res = skipZeroOrMoreMatcher(
                    computed, mem, text, textStartAt, textLen, pattern, patternStartAt, patternLen);
            return memorize(computed, mem, textStartAt, patternStartAt, res);
        }

        boolean res = matchNextChar(computed, mem, text, textStartAt, textLen, pattern, patternStartAt, patternLen)
                || skipZeroOrMoreMatcher(computed, mem, text, textStartAt, textLen, pattern, patternStartAt, patternLen);
        return memorize(
                computed, mem, textStartAt, patternStartAt, res);
    }

    private boolean matchNextCharAndPattern(
            boolean[][] computed,
            boolean[][] mem,
            String text,
            int textStartAt,
            int textLen,
            String pattern,
            int patternStartAt,
            int patternLen
    ) {
        return isMatchRec(
                computed, mem, text, textStartAt + 1, textLen, pattern, patternStartAt + 1, patternLen);
    }

    private boolean matchNextChar(
            boolean[][] computed,
            boolean[][] mem,
            String text,
            int textStartAt,
            int textLen,
            String pattern,
            int patternStartAt,
            int patternLen
    ) {
        return isMatchRec(computed, mem, text, textStartAt + 1, textLen, pattern, patternStartAt, patternLen);
    }

    private boolean skipZeroOrMoreMatcher(
            boolean[][] computed,
            boolean[][] mem,
            String text,
            int textStartAt,
            int textLen,
            String pattern,
            int patternStartAt,
            int patternLen
    ) {
        return isMatchRec(computed, mem, text, textStartAt, textLen, pattern, patternStartAt + 2, patternLen);
    }

    private boolean memorize(
            boolean[][] computed, boolean[][] mem, int textStartAt, int patternStartAt, boolean value) {
        computed[textStartAt][patternStartAt] = true;
        mem[textStartAt][patternStartAt] = value;
        return value;
    }

    private boolean isSingleCharMatch(
            String text,
            int textStartAt,
            int textLen,
            String pattern,
            int patternStartAt,
            int patternLen
    ) {
        if (textStartAt >= textLen || patternStartAt >= patternLen) {
            return false;
        }
        char textChar = text.charAt(textStartAt);
        char patternChar = pattern.charAt(patternStartAt);
        return patternChar == ANY_CHAR || patternChar == textChar;
    }

    private boolean hasOneCharLeft(int currIdx, int strLen) {
        return currIdx == strLen - 1;
    }

    private boolean hasNoCharLeft(int currIdx, int strLen) {
        return currIdx >= strLen;
    }
}
