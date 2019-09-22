/**
 * https://leetcode.com/problems/longest-palindromic-substring
 *
 * @author Harry Liu
 * @version Sept 22th, 2019
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int strLen = s.length();

        if (strLen == 0) {
            return s;
        }

        if (strLen == 1) {
            return s;
        }

        Palindrome maxLenPalindrome = new Palindrome(1, 0);
        int end = 2 * strLen - 3;

        for (int center = 0; center <= end; center++) {
            Palindrome palindrome = longestPalindromeLengthCenteredAt(s, center);

            if (palindrome.length > maxLenPalindrome.length) {
                maxLenPalindrome = palindrome;
            }
        }

        return s.substring(maxLenPalindrome.startAt, maxLenPalindrome.startAt + maxLenPalindrome.length);
    }

    private Palindrome longestPalindromeLengthCenteredAt(String str, int center) {
        boolean isCenterOddIdx = isOdd(center);

        int left = calcLeftStartAt(center, isCenterOddIdx);
        int right = calcRightStartAt(center);

        int palindromeLen = 0;
        if (isCenterOddIdx) {
            palindromeLen = 1;
        }

        int strLen = str.length();

        while (left >= 0 && right < strLen && str.charAt(left) == str.charAt(right)) {
            palindromeLen += 2;
            left--;
            right++;
        }

        return new Palindrome(palindromeLen, left + 1);
    }

    private int calcLeftStartAt(int center, boolean isCenterOddIdx) {
        int idx = (center + 1) / 2;

        if (isCenterOddIdx) {
            return idx - 1;
        }

        return idx;
    }

    private int calcRightStartAt(int center) {
        int idx = (center + 1) / 2;
        return idx + 1;
    }

    private boolean isOdd(int num) {
        return num % 2 == 1;
    }

    static class Palindrome {
        int length;
        int startAt;

        Palindrome(int length, int startAt) {
            this.length = length;
            this.startAt = startAt;
        }
    }
}
