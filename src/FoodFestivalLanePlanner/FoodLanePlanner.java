package FoodFestivalLanePlanner;

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