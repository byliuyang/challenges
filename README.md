# Challenges
Clean coding solutions written in Java

## What are included?

| #   | Description                                                                                                                    | Solution                                                                           | Performance      |
|-----|--------------------------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------|------------------|
| 1   | [Two Sum](https://leetcode.com/problems/two-sum)                                                                               | [TwoSum.java](src/main/java/TwoSum.java)                                           | Beat **98.8%**   |
| 2   | [Add Two Numbers](https://leetcode.com/problems/add-two-numbers)                                                               | [AddTwoNumbers.java](src/main/java/AddTwoNumbers.java)                             | Beat **100%**    |
| 3   | [Longest Substring Without repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters) | [LongestSubstrNoRepeatChars.java](src/main/java/LongestSubstrNoRepeatChars.java)   | Beat **99.86%**  |
| 4   | [Median of Two Sorted Arrays](https://leetcode.com/problems/median-of-two-sorted-arrays)                                       | [MedianTwoSortedArrays.java](src/main/java/MedianTwoSortedArrays.java)             | Beat **100.00%** |
| 5   | [Longest Palindromic Substring](https://leetcode.com/problems/longest-palindromic-substring)                                   | [LongestPalindromicSubstring.java](src/main/java/LongestPalindromicSubstring.java) | Beat **86.88%**  |
| 6   | [ZigZag Conversion](https://leetcode.com/problems/zigzag-conversion)                                                           | [ZigZagConversion.java](src/main/java/ZigZagConversion.java)                       | Beat **95.76%**  |
| 7   | [Reverse Integer](https://leetcode.com/problems/reverse-integer)                                                               | [ReverseInteger.java](src/main/java/ReverseInteger.java)                           | Beat **100%**    |
| 8   | [String to Integer](https://leetcode.com/problems/string-to-integer-atoi)                                                      | [StringToInteger.java](src/main/java/StringToInteger.java)                         | Beat **100%**    |
| 9   | [Palindrome Number](https://leetcode.com/problems/palindrome-number)                                                           | [PalindromeNumber.java](src/main/java/PalindromeNumber.java)                       | Beat **100%**    |
| 10  | [Regular Expression Matching](https://leetcode.com/problems/regular-expression-matching)                                       | [RegularExpressionMatching.java](src/main/java/RegularExpressionMatching.java)     | Beat **93.19%**  |
| 11  | [Container With Most Water](https://leetcode.com/problems/container-with-most-water)                                           | [ContainerWithMostWater.java](src/main/java/ContainerWithMostWater.java)           | Beat **95.44%**  |
| 12  | [Integer to Roman](https://leetcode.com/problems/integer-to-roman)                                                             | [IntegerToRoman.java](src/main/java/IntegerToRoman.java)                           | Beat **81.64**   |
| 13  | [Roman to Integer](https://leetcode.com/problems/roman-to-integer)                                                             | [RomanToInteger.java](src/main/java/RomanToInteger.java)                           | Beat **75.68**   |
| 14  | [Longest Common Prefix](https://leetcode.com/problems/longest-common-prefix)                                                   | [LongestCommonPrefix.java](src/main/java/LongestCommonPrefix.java)                 | Beat **100.00%** |
| 15  | [3 Sum](https://leetcode.com/problems/3sum/)                                                                                   | [ThreeSum.java](src/main/java/ThreeSum.java)                                       | Beat **92.57%**  |
| 16  | [3 Sum Closest](https://leetcode.com/problems/3sum-closest/)                                                                   | [ThreeSumClosest.java](src/main/java/ThreeSumClosest.java)                         | Beat **86.03%**  |
| 17  | [Letter Combinations of a Phone Number](https://leetcode.com/problems/letter-combinations-of-a-phone-number)                   | [TelephoneKeypad.java](src/main/java/TelephoneKeypad.java)                         | Beat **72.3%**   |
| 18  | [4 Sum](https://leetcode.com/problems/4sum)                                                                                    | [FourSum.java](src/main/java/FourSum.java)                                         | Beat **83.12%**  |
| 19  | [Remove Nth Node From End of List](https://leetcode.com/problems/remove-nth-node-from-end-of-list)                             | [RemoveNodeEndOfList.java](src/main/java/RemoveNodeEndOfList.java)                 | Beat **100.00%** |
| 20  | [Valid Parentheses](https://leetcode.com/problems/valid-parentheses)                                                           | [ValidParentheses.java](src/main/java/ValidParentheses.java)                       | Beat **98.71%**  |
| 21  | [Merge Two Sorted Lists](https://leetcode.com/problems/merge-two-sorted-lists)                                                 | [MergeTwoSortedLists.java](src/main/java/MergeTwoSortedLists.java)                 | Beat **100%**    |
| 22  | [Generate Parentheses](https://leetcode.com/problems/generate-parentheses)                                                     | [GenerateParentheses.java](src/main/java/GenerateParentheses.java)                 | Beat **87.83%**  |
| 914 | [X of a Kind in a Deck of Cards](https://leetcode.com/problems/x-of-a-kind-in-a-deck-of-cards)                                 | [GroupsOfCards.java](src/main/java/GroupsOfCards.java)                             | Beat **74.39%**  |

## FAQs
### I saw some of the solutions are not beating 100% of submissions, should I still use them as reference for interview preparation?
Yes. Some of them don't have perfect runtime due to the following reasons:

1. Leetcode online judge test runner is unstable. It sometimes slows down the solutions' runtime by milliseconds, which 
has big impacts on their performance percentile.

2. Some of the Leetcode submissions are over optimized for online judge system, such as putting all business logic in a
giant function, using math tricks, or hardcode all test cases. The giant function approach sacrifices code cleanness, 
which is one of the important grading metrics for coding interviews. The math tricks cannot assess how good you are at 
coding, which is another grading metric of coding interview.

## Author
Harry Liu - [byliuyang](https://github.com/byliuyang)

## License
This project is maintained under MIT license.
