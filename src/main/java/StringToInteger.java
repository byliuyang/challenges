public class StringToInteger {
    public int myAtoi(String str) {
        if (str == null) {
            return 0;
        }

        int strLen = str.length();
        if (strLen < 1) {
            return 0;
        }

        int startAt = skipWhiteSpaces(str, strLen);
        if (startAt >= strLen) {
            return 0;
        }

        long num = toNumber(str, strLen, startAt);

        if (num < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        if (num > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }

        return (int) num;
    }

    private long toNumber(String str, int strLen, int startAt) {
        long num = 0;
        int decimal = 10;

        final char PLUS_SIGN = '+';
        final char MINUS_SIGN = '-';
        final int POSITIVE = 1;
        final int NEGATIVE = -1;

        int sign = POSITIVE;

        int firstChar = str.charAt(startAt);
        if (firstChar == MINUS_SIGN || firstChar == PLUS_SIGN) {
            startAt++;
        }

        if (firstChar == MINUS_SIGN) {
            sign = NEGATIVE;
        }

        for (int idx = startAt; idx < strLen; idx++) {
            char currChar = str.charAt(idx);
            if (!isDigit(currChar)) {
                break;
            }

            int digit = toDigit(currChar);
            num = num * decimal + digit;

            if (num > Integer.MAX_VALUE) {
                break;
            }
        }
        return sign * num;
    }

    private int toDigit(char character) {
        return character - '0';
    }

    private boolean isDigit(char character) {
        if (character < '0') {
            return false;
        }

        if (character > '9') {
            return false;
        }

        return true;
    }

    private int skipWhiteSpaces(String str, int strLen) {
        final int SPACE = ' ';
        for (int currIdx = 0; currIdx < strLen; currIdx++) {
            if (str.charAt(currIdx) != SPACE) {
                return currIdx;
            }
        }
        return strLen;
    }
}
