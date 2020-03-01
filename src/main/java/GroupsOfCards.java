/**
 * @author Harry Liu
 * @version Sep 29, 2019
 * @challenge https://leetcode.com/problems/x-of-a-kind-in-a-deck-of-cards
 */
public class GroupsOfCards {
    public boolean hasGroupsSizeX(int[] deck) {
        if (deck == null) {
            return false;
        }

        if (deck.length < 2) {
            return false;
        }

        final int VALUE_LESS_THAN = 10000;
        int[] frequencies = countFrequencies(deck, VALUE_LESS_THAN);

        int groupSize = 0;
        for (int frequency : frequencies) {
            if (frequency == 0) {
                continue;
            }
            if (frequency == 1) {
                return false;
            }
            groupSize = greatestCommonDivisor(groupSize, frequency);
            if (groupSize == 1) {
                return false;
            }
        }

        return groupSize >= 2;
    }

    private int greatestCommonDivisor(int numA, int numB) {
        if (numB == 0) {
            return numA;
        }
        return greatestCommonDivisor(numB, numA % numB);
    }

    private int[] countFrequencies(int[] nums, int maxValue) {
        int[] frequencies = new int[maxValue];
        for (int num : nums) {
            frequencies[num]++;
        }
        return frequencies;
    }
}
