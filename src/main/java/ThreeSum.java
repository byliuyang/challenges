import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null) {
            return new ArrayList<>();
        }
        if (nums.length < 3) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);
        List<List<Integer>> combinations = new LinkedList<>();

        for (int idxA = 0; idxA < nums.length - 2; idxA++) {
            int numA = nums[idxA];
            if (shouldSkipDuplicateLeft(nums, 0, numA, idxA)) {
                continue;
            }

            List<Integer[]> indicesList = twoSumNoDuplicate(nums, -numA, idxA + 1);
            for (Integer[] indices : indicesList) {
                int idxB = indices[0];
                int idxC = indices[1];
                int numB = nums[idxB];
                int numC = nums[idxC];
                combinations.add(Arrays.asList(numA, numB, numC));
            }
        }
        return combinations;
    }

    private List<Integer[]> twoSumNoDuplicate(int[] nums, int sum, int startAt) {
        List<Integer[]> indicesList = new ArrayList<>();
        int leftIdx = startAt;
        int rightIdx = nums.length - 1;

        while (leftIdx < rightIdx) {
            int leftNum = nums[leftIdx];
            int rightNum = nums[rightIdx];
            int currSum = leftNum + rightNum;

            if (currSum < sum) {
                leftIdx++;
                continue;
            }
            if (currSum > sum) {
                rightIdx--;
                continue;
            }

            if (shouldSkipDuplicateLeft(nums, startAt, leftNum, leftIdx)) {
                leftIdx++;
                continue;
            }
            if (shouldSkipDuplicateRight(nums, nums.length - 1, rightNum, rightIdx)) {
                rightIdx--;
                continue;
            }

            Integer[] indices = new Integer[]{leftIdx, rightIdx};
            indicesList.add(indices);
            leftIdx++;
            rightIdx--;
        }
        return indicesList;
    }

    private boolean shouldSkipDuplicateLeft(int[] nums, int startAt, int currNum, int currIdx) {
        if (currIdx == startAt) {
            return false;
        }
        return currNum == nums[currIdx - 1];
    }

    private boolean shouldSkipDuplicateRight(int[] nums, int endAt, int currNum, int currIdx) {
        if (currIdx == endAt) {
            return false;
        }
        return currNum == nums[currIdx + 1];
    }
}
