import java.util.Arrays;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters
 *
 * @author Harry Liu
 * @version Sept 12th, 2019
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