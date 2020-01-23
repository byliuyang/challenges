/**
 * @author Harry Liu
 * @version Jan 22th, 2020
 *
 * @challenge https://leetcode.com/problems/container-with-most-water
 * @solution Search from both ends. As the width decreases, only increase in water level may result in larger
 * container.
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        if (height == null) {
            return 0;
        }

        if (height.length < 2) {
            return 0;
        }

        int maxArea = 0;

        int startAt = 0;
        int endAt = height.length - 1;

        while (startAt < endAt) {
            int width = endAt - startAt;
            int startHeight = height[startAt];
            int endHeight = height[endAt];

            int minHeight = Math.min(startHeight, endHeight);
            int area = width * minHeight;
            maxArea = Math.max(maxArea, area);

            if (startHeight <= endHeight) {
                startAt = findHigherEdgeToTheRight(height, startAt, endAt, minHeight);
                continue;
            }
            endAt = findHigherEdgeToTheLeft(height, startAt, endAt, minHeight);
        }

        return maxArea;
    }

    private int findHigherEdgeToTheRight(int[] height, int startAt, int endAt, int minHeight) {
        while (startAt < endAt && height[startAt] <= minHeight) {
            startAt++;
        }
        return startAt;
    }

    private int findHigherEdgeToTheLeft(int[] height, int startAt, int endAt, int minHeight) {
        while (startAt < endAt && height[endAt] <= minHeight) {
            endAt--;
        }
        return endAt;
    }
}
