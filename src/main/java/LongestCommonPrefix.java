/**
 * @author Harry Liu
 * @version Jan 29, 2020
 *
 * @challenge https://leetcode.com/problems/longest-common-prefix
 * @solution Compare every char of the first string to the rest of the strings and stop when there is a mismatch.
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] texts) {
        if (texts == null) {
            return "";
        }

        if (texts.length < 1) {
            return "";
        }

        if (texts.length < 2) {
            return texts[0];
        }

        int minLen = findMinStrLength(texts);
        String firstStr = texts[0];
        StringBuilder commonPrefix = new StringBuilder();

        for (int idx = 0; idx < minLen; idx++) {
            char commonPrefixChar = firstStr.charAt(idx);
            if (!isCommonChar(texts, commonPrefixChar, idx)) {
                return commonPrefix.toString();
            }
            commonPrefix.append(commonPrefixChar);
        }
        return commonPrefix.toString();
    }

    private boolean isCommonChar(String[] texts, char commonPrefixChar, int idx) {
        for (String text : texts) {
            if (text.charAt(idx) != commonPrefixChar) {
                return false;
            }
        }
        return true;
    }

    private int findMinStrLength(String[] texts) {
        int minLen = texts[0].length();
        for (String str : texts) {
            minLen = Math.min(minLen, str.length());
        }
        return minLen;
    }
}
