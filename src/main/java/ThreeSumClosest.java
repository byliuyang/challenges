import java.util.Arrays;

/**
 * @author Harry Liu
 * @version Feb 29, 2020
 * @challenge https://leetcode.com/problems/3sum-closest/
 * @solution Pick the 1st number and run 2 sum closest on the rest of the numbers.
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null) {
            return 0;
        }

        if (nums.length < 3) {
            return 0;
        }

        int closestSum = nums[0] + nums[1] + nums[nums.length - 1];
        int closestDistance = distance(closestSum, target);
        Arrays.sort(nums);
        for (int idx = 0; idx < nums.length - 2; idx++) {
            int num = nums[idx];
            int twoSumTarget = target - num;
            int twoSum = twoSumClosest(nums, idx + 1, twoSumTarget);
            int threeSum = num + twoSum;
            int threeSumDistance = distance(threeSum, target);

            if (threeSumDistance < closestDistance) {
                closestSum = threeSum;
                closestDistance = threeSumDistance;
            }

        }
        return closestSum;
    }

    public int twoSumClosest(int[] sortedNums, int start, int target) {
        int end = sortedNums.length - 1;
        int closestSum = sortedNums[start] + sortedNums[end];
        int closestDistance = distance(closestSum, target);

        while (start < end) {
            int twoSum = sortedNums[start] + sortedNums[end];
            int twoSumDistance = distance(twoSum, target);

            if (twoSumDistance < closestDistance) {
                closestSum = twoSum;
                closestDistance = twoSumDistance;
            }
            if (twoSum <= target) {
                start++;
            } else {
                end--;
            }
        }
        return closestSum;
    }

    private int distance(int num1, int num2) {
        return Math.abs(num1 - num2);
    }
}
