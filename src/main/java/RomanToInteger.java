import java.util.HashMap;
import java.util.Map;

/**
 * @author Harry Liu
 * @version Jan 27, 2019
 *
 * @challenge https://leetcode.com/problems/roman-to-integer
 * @solution Undo previously added 1 unit when encountered 5 or 10 units.
 */
public class RomanToInteger {
    private static final Map<Character, Character> shouldSubtractMap;
    private static final Map<Character, Integer> romanNumToIntMap;

    static {
        shouldSubtractMap = new HashMap<>();
        shouldSubtractMap.put('V', 'I');
        shouldSubtractMap.put('X', 'I');
        shouldSubtractMap.put('L', 'X');
        shouldSubtractMap.put('C', 'X');
        shouldSubtractMap.put('D', 'C');
        shouldSubtractMap.put('M', 'C');

        romanNumToIntMap = new HashMap<>();
        romanNumToIntMap.put('I', 1);
        romanNumToIntMap.put('V', 5);
        romanNumToIntMap.put('X', 10);
        romanNumToIntMap.put('L', 50);
        romanNumToIntMap.put('C', 100);
        romanNumToIntMap.put('D', 500);
        romanNumToIntMap.put('M', 1000);
    }

    public int romanToInt(String s) {
        if (s == null) {
            return 0;
        }

        int romanLen = s.length();

        if (romanLen < 1) {
            return 0;
        }

        if (romanLen < 2) {
            return romanNumToInt(s.charAt(0));
        }

        char romanNum = s.charAt(0);
        int resNum = romanNumToInt(romanNum);

        char prevRomanNum = romanNum;
        int prevNum = resNum;

        for (int idx = 1; idx < romanLen; idx++) {
            romanNum = s.charAt(idx);
            int currNum = romanNumToInt(romanNum);

            resNum += currNum;
            if (shouldSubtract(romanNum, prevRomanNum)) {
                resNum -= 2 * prevNum;
            }

            prevRomanNum = romanNum;
            prevNum = currNum;
        }
        return resNum;
    }

    private boolean shouldSubtract(char currRomanNum, char prevRomanChar) {
        if (currRomanNum == 'I') {
            return false;
        }
        return shouldSubtractMap.get(currRomanNum) == prevRomanChar;
    }

    private int romanNumToInt(char romanChar) {
        if (!romanNumToIntMap.containsKey(romanChar)) {
            return -1;
        }
        return romanNumToIntMap.get(romanChar);
    }
}
