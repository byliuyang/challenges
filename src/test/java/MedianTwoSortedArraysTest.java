import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 *
 * @author Harry Liu
 * @version Sept 21th, 2019
 */
class MedianTwoSortedArraysTest {
    private MedianTwoSortedArrays medianTwoSortedArrays;

    @BeforeEach
    void createMedianTwoSortedArrays() {
        medianTwoSortedArrays = new MedianTwoSortedArrays();
    }

    @Tag("fast")
    @Test
    void findMedianSortedArrays() {
        class TestCase {
            private int[] nums1;
            private int[] nums2;
            private double expMedium;

            private TestCase(int[] nums1, int[] nums2, double expMedium) {
                this.nums1 = nums1;
                this.nums2 = nums2;
                this.expMedium = expMedium;
            }
        }

        TestCase[] testCases = {
                new TestCase(new int[]{3}, new int[]{-2, -1}, -1.0),
                new TestCase(new int[]{2, 4, 5}, new int[]{1, 3, 6, 7}, 4),
                new TestCase(new int[]{1}, new int[]{2, 3, 4, 5}, 3),
                new TestCase(new int[]{5, 9, 10}, new int[]{1, 2, 3, 4, 6, 7, 8}, 5.5),
                new TestCase(new int[]{1, 2}, new int[]{-1, 3}, 1.5),
                new TestCase(new int[]{1, 2}, new int[]{3, 4}, 2.5),
                new TestCase(new int[]{100001}, new int[]{100000}, 100000.5),
                new TestCase(new int[]{}, new int[]{2, 3}, 2.5)
        };

        for (TestCase testCase : testCases) {
            double got = medianTwoSortedArrays.findMedianSortedArrays(testCase.nums1, testCase.nums2);
            assertEquals(testCase.expMedium, got);
        }
    }
}