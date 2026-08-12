// Last updated: 12/08/2026, 19:08:40
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
        Map<Integer, Integer> rows = new HashMap<>();
        Map<Integer, Integer> cols = new HashMap<>();
        Map<Integer, Integer> diag1 = new HashMap<>(); // r - c
        Map<Integer, Integer> diag2 = new HashMap<>(); // r + c
        Set<Long> lampsSet = new HashSet<>();
        
        // Step 1: Initialize counters and populate active lamps
        for (int[] lamp : lamps) {
            int r = lamp[0];
            int c = lamp[1];
            // Use bit-shifting to cleanly encode the 2D coordinate into a unique 64-bit Long
            long hash = ((long) r << 32) + c; 
            
            if (!lampsSet.contains(hash)) {
                lampsSet.add(hash);
                rows.put(r, rows.getOrDefault(r, 0) + 1);
                cols.put(c, cols.getOrDefault(c, 0) + 1);
                diag1.put(r - c, diag1.getOrDefault(r - c, 0) + 1);
                diag2.put(r + c, diag2.getOrDefault(r + c, 0) + 1);
            }
        }
        
        int[] ans = new int[queries.length];
        
        // Step 2: Process queries
        for (int i = 0; i < queries.length; i++) {
            int r = queries[i][0];
            int c = queries[i][1];
            
            // Check if the current position is illuminated
            if (rows.getOrDefault(r, 0) > 0 || 
                cols.getOrDefault(c, 0) > 0 || 
                diag1.getOrDefault(r - c, 0) > 0 || 
                diag2.getOrDefault(r + c, 0) > 0) {
                ans[i] = 1;
            } else {
                ans[i] = 0;
            }
            
            // Turn off lamps in the 3x3 neighborhood around the query
            for (int dr = -1; dr <= 1; dr++) {
                for (int dc = -1; dc <= 1; dc++) {
                    int nr = r + dr;
                    int nc = c + dc;
                    
                    if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
                        long neighborHash = ((long) nr << 32) + nc;
                        if (lampsSet.contains(neighborHash)) {
                            // Turn off the lamp and reduce lines' coverage counters
                            lampsSet.remove(neighborHash);
                            rows.put(nr, rows.get(nr) - 1);
                            cols.put(nc, cols.get(nc) - 1);
                            diag1.put(nr - nc, diag1.get(nr - nc) - 1);
                            diag2.put(nr + nc, diag2.get(nr + nc) - 1);
                        }
                    }
                }
            }
        }
        
        return ans;
    }
}