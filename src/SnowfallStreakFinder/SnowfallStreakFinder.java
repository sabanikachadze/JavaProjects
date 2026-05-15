package SnowfallStreakFinder;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SnowfallStreakFinder {

    public static int[] longestStableStreak(int[] snowfall, int k) {
        if (snowfall.length == 0) return new int[0];

        Deque<Integer> maxD = new ArrayDeque<>();
        Deque<Integer> minD = new ArrayDeque<>();

        int left = 0, bestLeft = 0, bestLen = 0;

        for (int right = 0; right < snowfall.length; right++) {

            while (!maxD.isEmpty() && snowfall[maxD.peekLast()] <= snowfall[right])
                maxD.pollLast();
            maxD.addLast(right);

            while (!minD.isEmpty() && snowfall[minD.peekLast()] >= snowfall[right])
                minD.pollLast();
            minD.addLast(right);

            while (snowfall[maxD.peekFirst()] - snowfall[minD.peekFirst()] > k) {
                left++;
                if (maxD.peekFirst() < left) maxD.pollFirst();
                if (minD.peekFirst() < left) minD.pollFirst();
            }

            if (right - left + 1 > bestLen) {
                bestLen  = right - left + 1;
                bestLeft = left;
            }
        }

        return Arrays.copyOfRange(snowfall, bestLeft, bestLeft + bestLen);
    }

    public static void main(String[] args) {
        int[] sample      = {5, 7, 4, 6, 8, 7, 5, 3, 4, 6};
        System.out.println(Arrays.toString(longestStableStreak(sample, 3)));       // expected: [5, 7, 4, 6]

        int[] empty       = {};
        System.out.println(Arrays.toString(longestStableStreak(empty, 5)));        // expected: []

        int[] descending  = {2, 6, 4, 3, 5};
        System.out.println(Arrays.toString(longestStableStreak(descending, 2)));   // expected: [4, 3, 5]

        int[] ascending   = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(longestStableStreak(ascending, 2)));    // expected: [1, 2, 3]

        int[] kIsZero     = {3, 3, 3, 4, 3};
        System.out.println(Arrays.toString(longestStableStreak(kIsZero, 0)));      // expected: [3, 3, 3]

        int[] spike       = {5, 5, 5, 20, 5, 5, 5};
        System.out.println(Arrays.toString(longestStableStreak(spike, 3)));        // expected: [5, 5, 5]

        int[] streakStart = {2, 3, 4, 3, 20, 50};
        System.out.println(Arrays.toString(longestStableStreak(streakStart, 2)));  // expected: [2, 3, 4, 3]

        int[] twoStreaks  = {1, 2, 3, 10, 11, 12, 5};
        System.out.println(Arrays.toString(longestStableStreak(twoStreaks, 2)));   // expected: [1, 2, 3]

        int[] largeK      = {1, 100, 50, 200, 10};
        System.out.println(Arrays.toString(longestStableStreak(largeK, 1000)));    // expected: [1, 100, 50, 200, 10]

        int[] alternating = {1, 5, 1, 5, 1, 5};
        System.out.println(Arrays.toString(longestStableStreak(alternating, 3)));  // expected: [1]

        int[] allMax      = {1000, 1000, 1000, 1000};
        System.out.println(Arrays.toString(longestStableStreak(allMax, 0)));       // expected: [1000, 1000, 1000, 1000]

        int[] twoElements = {3, 7};
        System.out.println(Arrays.toString(longestStableStreak(twoElements, 3)));  // expected: [3]
    }
}