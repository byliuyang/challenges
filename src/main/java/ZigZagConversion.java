/**
 * @author Harry Liu
 * @version Sept 23, 2019
 * @challenge https://leetcode.com/problems/zigzag-conversion
 * @solution Convert array indices into row and column numbers.
 */
public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if (numRows < 2) {
            return s;
        }

        int strLen = s.length();
        if (strLen <= numRows) {
            return s;
        }

        StringBuilder buffer = new StringBuilder();
        int offset = calcOffset(numRows);

        appendRow(buffer, 0, offset, s, strLen);
        appendRowsContainDiagonal(buffer, numRows, offset, s, strLen);
        appendRow(buffer, numRows - 1, offset, s, strLen);

        return buffer.toString();
    }

    private void appendRowsContainDiagonal(
            StringBuilder buffer,
            int numRows,
            int offset,
            String str,
            int strLen
    ) {
        for (int rowIdx = 1; rowIdx < numRows - 1; rowIdx++) {
            appendRowContainsDiagonal(buffer, numRows, rowIdx, offset, str, strLen);
        }
    }

    private void appendRowContainsDiagonal(
            StringBuilder buffer,
            int numRows,
            int rowIdx,
            int offset,
            String str,
            int strLen
    ) {
        for (int startAt = rowIdx; startAt < strLen; startAt += offset) {
            buffer.append(str.charAt(startAt));
            appendDiagonalChar(buffer, startAt, numRows, rowIdx, str, strLen);
        }
    }

    private void appendDiagonalChar(
            StringBuilder buffer,
            int startAt,
            int numRows,
            int rowIdx,
            String str,
            int strLen
    ) {
        int diagonalCharIdx = calcDiagonalCharIdx(startAt, numRows, rowIdx);
        if (diagonalCharIdx >= strLen) {
            return;
        }
        buffer.append(str.charAt(diagonalCharIdx));
    }

    private int calcDiagonalCharIdx(int startAt, int numRows, int rowIdx) {
        return startAt + 2 * (numRows - rowIdx - 1);
    }

    private void appendRow(StringBuilder buffer, int rowIdx, int offset, String str, int strLen) {
        for (int startAt = rowIdx; startAt < strLen; startAt += offset) {
            buffer.append(str.charAt(startAt));
        }
    }

    private int calcOffset(int numRows) {
        return 2 * (numRows - 1);
    }
}
