import java.util.Arrays;

/**
 * @author Harry Liu
 * @version Sept 12, 2019
 *
 * @challenge https://leetcode.com/problems/longest-substring-without-repeating-characters
 * @solution Slide window from left to right. Cache the index of the last appearance of the repeated char.
 */
public class LongestSubstrNoRepeatChars {
    public static int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();

        if (chars.length < 2) {
            return chars.length;
        }

        int NUM_CHARS = 128;
        int[] lastAppears = new int[NUM_CHARS];
        Arrays.fill(lastAppears, -1);

        int start = 0;
        int maxLen = 1;
        lastAppears[chars[0]] = 0;

        for (int end = 1; end < chars.length; end++) {
            char endChar = chars[end];
            if (lastAppears[endChar] < start) {
                maxLen = Math.max(maxLen, end - start + 1);
            } else {
                start = lastAppears[endChar] + 1;
            }
            lastAppears[endChar] = end;
        }

        return maxLen;
    }
}