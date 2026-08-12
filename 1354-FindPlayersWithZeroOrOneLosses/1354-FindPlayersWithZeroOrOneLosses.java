// Last updated: 12/08/2026, 19:07:37
import java.util.*;

class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {

        Map<Integer, Integer> losses = new HashMap<>();

        for (int[] match : matches) {
            int winner = match[0];
            int loser = match[1];

            losses.putIfAbsent(winner, 0);
            losses.put(loser, losses.getOrDefault(loser, 0) + 1);
        }

        List<Integer> zero = new ArrayList<>();
        List<Integer> one = new ArrayList<>();

        for (int player : losses.keySet()) {
            if (losses.get(player) == 0)
                zero.add(player);
            else if (losses.get(player) == 1)
                one.add(player);
        }

        Collections.sort(zero);
        Collections.sort(one);

        return Arrays.asList(zero, one);
    }
}