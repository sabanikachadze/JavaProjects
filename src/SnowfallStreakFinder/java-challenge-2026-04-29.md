# Snowfall Streak Finder

## Topic
Data Structures & Algorithms — Sliding Window with Monotonic Deques

## Difficulty
Intermediate

## Estimated time
30–45 minutes

## Problem statement
You're building an analytics tool for a mountain weather station. The station logs daily snowfall (in centimeters) for a stretch of winter days, and the lead meteorologist wants to identify the **longest streak of consecutive days** during which conditions stayed "stable" — meaning that on any two days in that streak, the snowfall amounts never differed by more than a tolerance value `k`.

Given an integer array `snowfall` and a non-negative integer `k`, return the length of the longest **contiguous** subarray such that:

```
max(subarray) - min(subarray) <= k
```

## Requirements
- Implement a public class `SnowfallStreakFinder` with a single static method:
  - `public static int longestStableStreak(int[] snowfall, int k)`
- Average time complexity must be **O(n)**, where `n = snowfall.length`.
- Must handle the empty array and a single-element array gracefully.
- Use only the standard Java library — no third-party dependencies.
- Idiomatic Java 17+ is encouraged (`var`, enhanced `switch`, etc., where they improve readability).

## Constraints
- `0 <= snowfall.length <= 100_000`
- `0 <= snowfall[i] <= 1_000`
- `0 <= k <= 1_000`
- A `TreeMap`-based O(n log n) solution will pass, but the intended solution is O(n) using two monotonic deques.

## Examples

**Example 1**
```java
int[] snow = {5, 7, 4, 6, 8, 7, 5, 3, 4, 6};
int k = 3;
SnowfallStreakFinder.longestStableStreak(snow, k); // returns 4
// Longest valid window: [5, 7, 4, 6]  →  max=7, min=4, diff=3
// Another valid window of length 4:    [6, 8, 7, 5]  →  diff=3
```

**Example 2**
```java
int[] snow = {10, 1, 2, 4, 7, 2};
int k = 5;
SnowfallStreakFinder.longestStableStreak(snow, k); // returns 4
// Window [1, 2, 4, 7] has diff=6  ✗
// Window [2, 4, 7, 2] has diff=5  ✓  (length 4)
```

**Example 3 — edge cases**
```java
SnowfallStreakFinder.longestStableStreak(new int[]{}, 5);    // 0
SnowfallStreakFinder.longestStableStreak(new int[]{42}, 0);  // 1
SnowfallStreakFinder.longestStableStreak(new int[]{3,3,3}, 0); // 3
```

## Starter code
```java
import java.util.*;

public class SnowfallStreakFinder {

    /**
     * Returns the length of the longest contiguous subarray of {@code snowfall}
     * in which the difference between the maximum and minimum value
     * does not exceed {@code k}.
     *
     * @param snowfall non-null array of daily snowfall measurements
     * @param k        non-negative tolerance (cm)
     * @return         length of the longest "stable" streak
     */
    public static int longestStableStreak(int[] snowfall, int k) {
        // TODO: implement using a two-pointer sliding window.
        // Hint: maintain two monotonic deques — one for the running max,
        //       one for the running min — so each step is amortized O(1).
        return 0;
    }

    public static void main(String[] args) {
        int[] sample = {5, 7, 4, 6, 8, 7, 5, 3, 4, 6};
        System.out.println(longestStableStreak(sample, 3)); // expected: 4

        int[] empty = {};
        System.out.println(longestStableStreak(empty, 5));  // expected: 0
    }
}
```

## Hints

<details>
<summary><b>Hint 1 (peek)</b></summary>

Think of two pointers, `left` and `right`, marking the current window. Slide `right` forward one day at a time. As long as the window is "stable" (max − min ≤ k), record its length. When stability breaks, advance `left` until the window is stable again.
</details>

<details>
<summary><b>Hint 2</b></summary>

Recomputing max and min by scanning the window each step gives an O(n²) solution. To stay at O(n), you need O(1) access to the current window's max and min as elements enter and leave. **Two `ArrayDeque<Integer>` instances** — one keeping a **decreasing** sequence of values (front = window max), the other keeping an **increasing** sequence (front = window min) — let you do exactly that.
</details>

<details>
<summary><b>Hint 3</b></summary>

When you append a new value `v` on the right:
- Pop from the **back** of the max-deque while its tail is `< v`, then push `v`.
- Pop from the **back** of the min-deque while its tail is `> v`, then push `v`.

Storing **indices** (not values) in the deques makes it easy to tell when the front has fallen out of the window: if `deque.peekFirst() < left`, poll it.

When you advance `left`, also poll any deque front whose index is now out of the window. The window is unstable while `snowfall[maxDeque.peekFirst()] - snowfall[minDeque.peekFirst()] > k`.
</details>

## Bonus / stretch goals
1. **Return the actual subarray**, not just its length. Decide which one to return when several have the same length (e.g., the earliest, or the one with the highest average snowfall).
2. **Streaming variant:** redesign the API so a new measurement can be appended one at a time and `longestStableStreak()` returns the running answer in amortized O(1) per call. What state do you need to keep?

## Self-check
1. What is the time and space complexity of your solution? Why is the inner `while`-loop body still amortized O(1) per element?
2. How do you handle **duplicate values** entering the deques? Does using `<` vs. `<=` when popping the back change correctness?
3. What does your code return when `k = 0`? Trace through `[3, 3, 3, 1, 1]`.
4. What are the trade-offs between two monotonic deques and a single `TreeMap<Integer, Integer>` keyed by value with multiplicity counts?
5. How would your design change if `k` itself varied across the array (e.g., a per-day tolerance)?

---
*Want the reference solution? Just ask in chat — but try the bonus first!*
