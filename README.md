# Challenges
Clean coding challenge solutions written in Java

## What is included?
| #            | Description                                                                                                                    | Solution                                                                           | Performance                     |
| ------------ | --------------------------------------                                                                                         | -----------------------------------------------------                              | ------------------------------- |
| 1            | [Two Sum](https://leetcode.com/problems/two-sum)                                                                               | [TwoSum.java](src/main/java/TwoSum.java)                                           | Beat **98.8%**                  |
| 2            | [Add Two Numbers](https://leetcode.com/problems/add-two-numbers)                                                               | [AddTwoNumbers.java](src/main/java/AddTwoNumbers.java)                             | Beat **100%**                   |
| 3            | [Longest Substring Without repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters) | [LongestSubstrNoRepeatChars.java](src/main/java/LongestSubstrNoRepeatChars.java)   | Beat **99.86%**                 |
| 4            | [Median of Two Sorted Arrays](https://leetcode.com/problems/median-of-two-sorted-arrays)                                       | [MedianTwoSortedArrays.java](src/main/java/MedianTwoSortedArrays.java)             | Beat **100.00%**                |
| 5            | [Longest Palindromic Substring](https://leetcode.com/problems/longest-palindromic-substring)                                   | [LongestPalindromicSubstring.java](src/main/java/LongestPalindromicSubstring.java) | Beat **86.88%**                 |

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