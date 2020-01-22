/**
 * @author Harry Liu
 * @version Jan 21th, 2020
 *
 * @challenge https://leetcode.com/problems/regular-expression-matching
 */

public class RegularExpressionMatching {
    private static final char ANY_CHAR = '.';
    private static final char ZERO_OR_MORE = '*';

    public boolean isMatch(String s, String p) {
        if (s == null && p == null) {
            return true;
        }

        if (s == null || p == null) {
            return false;
        }

        int textLen = s.length();
        int patternLen = p.length();
        boolean[][] computed = new boolean[textLen + 1][patternLen + 1];
        boolean[][] mem = new boolean[textLen + 1][patternLen + 1];
        return isMatchRec(computed, mem, s, 0, textLen, p, 0, patternLen);
    }

    private boolean isMatchRec(
            boolean[][] computed,
            boolean[][] mem,
            String text,
            int textIdx,
            int textLen,
            String pattern,
            int patternIdx,
            int patternLen
    ) {
        if (computed[textIdx][patternIdx]) {
            return mem[textIdx][patternIdx];
        }

        if (hasNoCharLeft(patternIdx, patternLen)) {
            boolean res = hasNoCharLeft(textIdx, textLen);
            return memorize(computed, mem, textIdx, patternIdx, res);
        }

        if (hasOneCharLeft(patternIdx, patternLen)) {
            boolean res = hasOneCharLeft(textIdx, textLen)
                    && isSingleCharMatch(text, textIdx, textLen, pattern, patternIdx, patternLen);
            return memorize(computed, mem, textIdx, patternIdx, res);
        }

        char patternNextChar = pattern.charAt(patternIdx + 1);

        if (patternNextChar != ZERO_OR_MORE) {
            if (!isSingleCharMatch(text, textIdx, textLen, pattern, patternIdx, patternLen)) {
                return memorize(computed, mem, textIdx, patternIdx, false);
            }
            boolean res = matchNextCharAndPattern(
                    computed, mem, text, textIdx, textLen, pattern, patternIdx, patternLen);
            return memorize(computed, mem, textIdx, patternIdx, res);
        }

        if (hasNoCharLeft(textIdx, textLen)) {
            boolean res = skipZeroOrMoreMatcher(
                    computed, mem, text, textIdx, textLen, pattern, patternIdx, patternLen);
            return memorize(computed, mem, textIdx, patternIdx, res);
        }

        if (!isSingleCharMatch(text, textIdx, textLen, pattern, patternIdx, patternLen)) {
            boolean res = skipZeroOrMoreMatcher(
                    computed, mem, text, textIdx, textLen, pattern, patternIdx, patternLen);
            return memorize(computed, mem, textIdx, patternIdx, res);
        }

        boolean res = matchNextChar(computed, mem, text, textIdx, textLen, pattern, patternIdx, patternLen)
                || skipZeroOrMoreMatcher(computed, mem, text, textIdx, textLen, pattern, patternIdx, patternLen);
        return memorize(
                computed, mem, textIdx, patternIdx, res);
    }

    private boolean matchNextCharAndPattern(
            boolean[][] computed,
            boolean[][] mem,
            String text,
            int textIdx,
            int textLen,
            String pattern,
            int patternIdx,
            int patternLen
    ) {
        return isMatchRec(
                computed, mem, text, textIdx + 1, textLen, pattern, patternIdx + 1, patternLen);
    }

    private boolean matchNextChar(
            boolean[][] computed,
            boolean[][] mem,
            String text,
            int textIdx,
            int textLen,
            String pattern,
            int patternIdx,
            int patternLen
    ) {
        return isMatchRec(computed, mem, text, textIdx + 1, textLen, pattern, patternIdx, patternLen);
    }

    private boolean skipZeroOrMoreMatcher(
            boolean[][] computed,
            boolean[][] mem,
            String text,
            int textIdx,
            int textLen,
            String pattern,
            int patternIdx,
            int patternLen
    ) {
        return isMatchRec(computed, mem, text, textIdx, textLen, pattern, patternIdx + 2, patternLen);
    }

    private boolean memorize(
            boolean[][] computed, boolean[][] mem, int textIdx, int patternIdx, boolean value) {
        computed[textIdx][patternIdx] = true;
        mem[textIdx][patternIdx] = value;
        return value;
    }

    private boolean isSingleCharMatch(
            String text,
            int textIdx,
            int textLen,
            String pattern,
            int patternIdx,
            int patternLen
    ) {
        if (textIdx >= textLen || patternIdx >= patternLen) {
            return false;
        }
        char textChar = text.charAt(textIdx);
        char patternChar = pattern.charAt(patternIdx);
        return patternChar == ANY_CHAR || patternChar == textChar;
    }

    private boolean hasOneCharLeft(int currIdx, int strLen) {
        return currIdx == strLen - 1;
    }

    private boolean hasNoCharLeft(int currIdx, int strLen) {
        return currIdx >= strLen;
    }
}
