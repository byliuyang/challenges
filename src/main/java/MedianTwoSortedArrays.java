/**
 * @author Harry Liu
 * @version Sept 21, 2019
 * @challenge https://leetcode.com/problems/median-of-two-sorted-arrays
 * @solution Group numbers into two halves, each of which contains the same number of elements.
 */
public class MedianTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0 && nums2.length == 0) {
            return 0;
        }

        int[] longArr = nums1;
        int[] shortArr = nums2;

        if (nums1.length < nums2.length) {
            longArr = nums2;
            shortArr = nums1;
        }

        int totalLen = shortArr.length + longArr.length;
        int halfTotalLen = totalLen / 2;

        int shortSplitAt = binarySearchSplitPoint(shortArr, longArr, halfTotalLen);
        if (shortSplitAt < 0) {
            return 0;
        }

        int longSplitAt = halfTotalLen - shortSplitAt;
        if (isOdd(totalLen)) {
            if (shortSplitAt == shortArr.length) {
                return longArr[longSplitAt];
            }

            return Math.min(shortArr[shortSplitAt], longArr[longSplitAt]);
        }

        int small = getSmallNum(shortSplitAt, longSplitAt, shortArr, longArr);
        int large = getLargeNum(shortSplitAt, longSplitAt, shortArr, longArr);

        return (small + large) / 2.0;
    }

    private int getSmallNum(int shortSplitAt, int longSplitAt, int[] shortArr, int[] longArr) {
        if (shortSplitAt == 0) {
            return longArr[longSplitAt - 1];
        }

        if (longSplitAt == 0) {
            return shortArr[shortSplitAt - 1];
        }

        return Math.max(shortArr[shortSplitAt - 1], longArr[longSplitAt - 1]);
    }

    private int getLargeNum(int shortSplitAt, int longSplitAt, int[] shortArr, int[] longArr) {
        if (shortSplitAt == shortArr.length) {
            return longArr[longSplitAt];
        }

        if (longSplitAt == longArr.length) {
            return shortArr[shortSplitAt];
        }
        return Math.min(shortArr[shortSplitAt], longArr[longSplitAt]);
    }

    private int binarySearchSplitPoint(int[] shortArr, int[] longArr, int halfTotalLen) {
        int start = 0;
        int end = shortArr.length;

        while (start <= end) {
            int shortSplitAt = (start + end) / 2;
            int longSplitAt = halfTotalLen - shortSplitAt;

            if (shortSplitAt > start && shortArr[shortSplitAt - 1] > longArr[longSplitAt]) {
                end = shortSplitAt - 1;
                continue;
            }

            if (shortSplitAt < end && longArr[longSplitAt - 1] > shortArr[shortSplitAt]) {
                start = shortSplitAt + 1;
                continue;
            }

            return shortSplitAt;
        }

        // Should not happen
        return -1;
    }

    private boolean isOdd(int num) {
        return num % 2 == 1;
    }
}
