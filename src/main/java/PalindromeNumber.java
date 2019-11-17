/**
 * @author Harry Liu
 * @version Nov 16th, 2019
 *
 * @challenge https://leetcode.com/problems/palindrome-number
 * @solution Reverse half the digits and check whether they are the same as the other half.
 *
 * Note:
 *
 * 1) Negative number cannot be palindrome number due to negative sign
 * 2) 0 is a palindrome number
 * 3) Other than 0 itself, numbers ended with zero is not palindrome number
 * 4) Middle digit needed to be removed from the reversed half if the original number has odd number of digits.
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        if (x == 0) {
            return true;
        }

        if (x % 10 == 0) {
            return false;
        }

        int reversedHalf = 0;
        while(reversedHalf < x) {
            int digit = x % 10;
            reversedHalf =  reversedHalf * 10 + digit;
            x /= 10;
        }

        if (x == reversedHalf) {
            return true;
        }

        return x == removeLastDigit(reversedHalf);
    }

    private int removeLastDigit(int num) {
        return num / 10;
    }
}
