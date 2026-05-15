# Food Festival Lane Planner

> *Your daily Java workout — sip your coffee, open IntelliJ, and let's go.*

---

## Topic
**Data Structures & Algorithms** — Sliding Window + Hash Map

## Difficulty
**Intermediate**

## Estimated Time
**35–50 minutes**

---

## Problem Statement

You're helping organize the annual **Riverside Food Festival**. Food trucks are parked along a single straight lane, each serving exactly one type of cuisine (e.g., `"thai"`, `"italian"`, `"ethiopian"`, `"mexican"`).

The festival's marketing director wants to print a **"Cuisine Trail"** map for guests: a *contiguous stretch* of food trucks visitors can walk through and sample. To keep guests from feeling overwhelmed, the trail must contain **at most `k` distinct cuisines**.

Your job: write a class `FoodLanePlanner` that, given the lane (a `List<String>`) and the cap `k`, returns:

1. The **maximum length** of any contiguous stretch of trucks containing at most `k` distinct cuisines.
2. The **start and end indices** (inclusive) of one such stretch. If multiple stretches tie, return the **earliest** (leftmost) one.

Then build a small CLI-style demo `main` that prints results for a few hardcoded lanes.

---

## Requirements

- Create a class `FoodLanePlanner` in package `com.festival.planner`.
- Expose a public method:
  ```java
  public TrailResult longestTrail(List<String> lane, int k);
  ```
- Define a Java **record**:
  ```java
  public record TrailResult(int length, int startIndex, int endIndex) {}
  ```
- Throw `IllegalArgumentException` if `lane` is `null` or `k < 0`.
- An empty lane or `k == 0` must return `new TrailResult(0, -1, -1)`.
- Provide a `public static void main(String[] args)` demonstrating at least three test cases (print results to stdout).

## Constraints

- `1 <= lane.size() <= 100_000`
- `0 <= k <= lane.size()`
- Each cuisine string is non-null and non-empty.
- **Time complexity target:** `O(n)` average, where `n = lane.size()`.
- **Space complexity target:** `O(k)` for the auxiliary structures.

---

## Examples

### Example 1
```java
List<String> lane = List.of("thai", "italian", "thai", "mexican", "italian", "italian");
int k = 2;
TrailResult result = new FoodLanePlanner().longestTrail(lane, k);
// result -> TrailResult[length=4, startIndex=2, endIndex=5]
// The trail ["thai", "mexican", "italian", "italian"] has 3 distinct... wait.
// Actually the longest with <=2 distinct is ["mexican", "italian", "italian"] (length 3)
// OR ["thai", "italian", "thai"] (length 3, starts earlier at index 0)
// Expected -> TrailResult[length=3, startIndex=0, endIndex=2]
```

### Example 2
```java
List<String> lane = List.of("a", "b", "c", "a", "a", "a", "b", "c");
int k = 1;
TrailResult result = new FoodLanePlanner().longestTrail(lane, k);
// Longest run of a single cuisine is "a","a","a","a" — wait, those aren't contiguous.
// Contiguous run of "a" is indices 3..5 (length 3).
// Expected -> TrailResult[length=3, startIndex=3, endIndex=5]
```

### Example 3
```java
List<String> lane = List.of("sushi", "sushi", "sushi");
int k = 5;
TrailResult result = new FoodLanePlanner().longestTrail(lane, k);
// Expected -> TrailResult[length=3, startIndex=0, endIndex=2]
```

---

## Starter Code

```java
package com.festival.planner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FoodLanePlanner {

    public record TrailResult(int length, int startIndex, int endIndex) {}

    public TrailResult longestTrail(List<String> lane, int k) {
        // TODO: validate inputs
        // TODO: handle edge cases (empty lane, k == 0)
        // TODO: sliding window with a HashMap<String, Integer> counting cuisines in window
        //       - expand 'right' each iteration
        //       - while distinct count > k, shrink from 'left'
        //       - track best window seen so far
        return new TrailResult(0, -1, -1);
    }

    public static void main(String[] args) {
        FoodLanePlanner planner = new FoodLanePlanner();

        // TODO: run at least three demo cases and print the results
        // Tip: use System.out.printf("Lane=%s k=%d -> %s%n", lane, k, planner.longestTrail(lane, k));
    }
}
```

---

## Hints

<details>
<summary><b>Hint 1 (peek — only if stuck)</b></summary>

Think of a window `[left, right]` that slides across the lane. Maintain a `Map<String, Integer>` of cuisine counts **inside the window only**. The map's `size()` is your current distinct-cuisine count.
</details>

<details>
<summary><b>Hint 2</b></summary>

Expand `right` by one each loop iteration. When the map's size exceeds `k`, advance `left`, decrementing counts and removing entries that hit zero — until the window is valid again. Then check whether `right - left + 1` beats your best length.
</details>

<details>
<summary><b>Hint 3</b></summary>

To return the **earliest** best stretch on ties, only update your best result when you find a window that is **strictly longer** than the previous best — never on equal length. That way the first (leftmost) maximum sticks.
</details>

---

## Bonus / Stretch Goals

1. **Streaming variant**: Add a method `acceptTruck(String cuisine)` that maintains the current best window as trucks arrive one at a time (think: the festival is still being set up).
2. **Most-popular cuisine**: Inside the winning window, also return the cuisine with the highest count (and its count) — extend the `TrailResult` record accordingly.

---

## Self-Check

1. What is the **time complexity** of your solution, and why is each element processed at most twice?
2. What happens when `k` is larger than the number of distinct cuisines in the entire lane? Did you handle it?
3. Why is `HashMap.size()` an `O(1)` distinct-count check, and what would change if you used `HashSet<String>` instead alongside the counts?
4. How does your code behave for `k = 0` with a non-empty lane — and is that consistent with your validation?
5. If two windows tie on length, which one does your code return, and how did you ensure that?

---

> Want to see a reference solution? Just ask in chat — *"show me the solution for today's challenge"* — and I'll walk through it line by line. Happy coding!
