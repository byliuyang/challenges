import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Harry Liu
 * @version Mar 2, 2020
 * @challenge https://leetcode.com/problems/4sum
 * @solution Simplify 4 sum into 2 sum.
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> combos = new ArrayList<>();

        if (nums == null) {
            return combos;
        }

        if (nums.length < 4) {
            return combos;
        }

        Arrays.sort(nums);
        for (int idx1 = 0; idx1 < nums.length - 3; idx1++) {
            if (isRepetition(nums, 0, idx1)) {
                continue;
            }

            int num1 = nums[idx1];
            if (areSumsTooLarge(num1, nums[idx1 + 1], nums[idx1 + 2], nums[idx1 + 3], target)) {
                break;
            }

            for (int idx2 = idx1 + 1; idx2 < nums.length - 2; idx2++) {
                if (isRepetition(nums, idx1 + 1, idx2)) {
                    continue;
                }

                int num2 = nums[idx2];
                if (areSumsTooLarge(num1, num2, nums[idx2 + 1], nums[idx2 + 2], target)) {
                    break;
                }

                int twoSumTarget = target - num1 - num2;
                List<int[]> twoSumCombos = twoSum(nums, idx2 + 1, twoSumTarget);
                collectQuadruplets(combos, num1, num2, twoSumCombos);
            }
        }
        return combos;
    }

    private boolean areSumsTooLarge(int num1, int num2, int num3, int num4, int target) {
        int minSum = num1 + num2 + num3 + num1;
        return minSum > target;
    }

    private boolean isRepetition(int[] nums, int start, int idx) {
        return idx > start && nums[idx] == nums[idx - 1];
    }

    private boolean isRepetitionReverseOrder(int[] nums, int end, int idx) {
        return idx < end && nums[idx] == nums[idx + 1];
    }

    private void collectQuadruplets(List<List<Integer>> combos, int num1, int num2, List<int[]> twoSumCombos) {
        for (int[] twoSumCombo : twoSumCombos) {
            int num3 = twoSumCombo[0];
            int num4 = twoSumCombo[1];
            List<Integer> combo = Arrays.asList(num1, num2, num3, num4);
            combos.add(combo);
        }
    }

    private List<int[]> twoSum(int[] nums, int start, int target) {
        List<int[]> combos = new ArrayList<>();
        int length = nums.length - 1;

        int left = start;
        int right = length;
        while (left < right) {
            if (isRepetition(nums, start, left)) {
                left++;
                continue;
            }

            if (isRepetitionReverseOrder(nums, length, right)) {
                right--;
                continue;
            }
            int leftNum = nums[left];
            int rightNum = nums[right];
            int sum = leftNum + rightNum;
            if (sum == target) {
                combos.add(new int[]{leftNum, rightNum});
                left++;
                right--;
                continue;
            }

            if (sum < target) {
                left++;
                continue;
            }
            right--;
        }
        return combos;
    }
}
