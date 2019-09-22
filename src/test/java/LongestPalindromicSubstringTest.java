import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestPalindromicSubstringTest {
    private LongestPalindromicSubstring longestPalindromicSubstring;

    @BeforeEach
    void createLongestPalindromicSubstring() {
        longestPalindromicSubstring = new LongestPalindromicSubstring();
    }

    @Test
    void longestPalindrome() {
        class TestCase {
            String inputString;
            String expSubstring;

            TestCase(String inputString, String expSubstring) {
                this.inputString = inputString;
                this.expSubstring = expSubstring;
            }
        }

        TestCase[] testCases = new TestCase[]{
                new TestCase("", ""),
                new TestCase("a", "a"),
                new TestCase("ab", "a"),
                new TestCase("babad", "bab"),
                new TestCase("cbbd", "bb"),
        };

        for (TestCase testCase : testCases) {
            String gotSubstring = longestPalindromicSubstring.longestPalindrome(testCase.inputString);
            assertEquals(testCase.expSubstring, gotSubstring);
        }
    }
}
