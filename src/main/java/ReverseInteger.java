/**
 * https://leetcode.com/problems/reverse-integer
 *
 * @author Harry Liu
 * @version Sept 25th, 2019
 */
public class ReverseInteger {
    public int reverse(int num) {
        if (num == 0) {
            return num;
        }

        long reversedNum = 0;
        int decimal = 10;

        while (num != 0) {
            int digit = num % decimal;
            reversedNum = reversedNum * decimal + digit;
            num /= decimal;
        }

        if (reversedNum > Integer.MAX_VALUE) {
            return 0;
        }

        if (reversedNum < Integer.MIN_VALUE) {
            return 0;
        }

        return (int) reversedNum;
    }
}
