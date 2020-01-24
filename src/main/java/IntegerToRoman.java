/**
 * @author Harry Liu
 * @version Jan 23, 2020
 *
 * @challenge https://leetcode.com/problems/integer-to-roman
 * @solution Convert 9, 5, 4 and 1 in batch.
 */
public class IntegerToRoman {
    public String intToRoman(int num) {
        StringBuilder builder = new StringBuilder();

        num = writeThousands(builder, num);

        char[] symbols = new char[]{'M', 'D', 'C', 'L', 'X', 'V', 'I'};
        int[] units = new int[]{1000, 500, 100, 50, 10, 5, 1};

        for (int idx = 2; idx < units.length; idx += 2) {
            int unit = units[idx];
            int count = num / unit;
            char symbol = symbols[idx];

            if (count == 9) {
                num = writeNineUnits(builder, num, unit, symbol, symbols, idx);
                continue;
            }

            if (count == 4) {
                num = writeFourUnits(builder, num, unit, symbol, symbols, idx);
                continue;
            }

            if (count >= 5) {
                writeFiveUnits(builder, symbols, idx);
                count -= 5;
            }

            num = writeBaseUnits(builder, num, unit, count, symbol);
        }

        return builder.toString();
    }

    private int writeBaseUnits(StringBuilder builder, int num, int unit, int count, char symbol) {
        writeSymbols(builder, count, symbol);
        return num % unit;
    }

    private int writeNineUnits(StringBuilder builder, int num, int unit, char symbol, char[] symbols, int idx) {
        builder.append(symbol);
        builder.append(symbols[idx - 2]);
        return num % unit;
    }

    private int writeFourUnits(StringBuilder builder, int num, int unit, char symbol, char[] symbols, int idx) {
        builder.append(symbol);
        builder.append(symbols[idx - 1]);
        return num % unit;
    }

    private void writeFiveUnits(StringBuilder builder, char[] symbols, int idx) {
        builder.append(symbols[idx - 1]);
    }

    private int writeThousands(StringBuilder builder, int num) {
        if (num < 1000) {
            return num;
        }
        int count = num / 1000;
        writeSymbols(builder, count, 'M');
        return num % 1000;
    }

    private void writeSymbols(StringBuilder builder, int count, char symbol) {
        for (int i = 0; i < count; i++) {
            builder.append(symbol);
        }
    }
}
