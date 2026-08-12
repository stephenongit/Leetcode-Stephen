// Last updated: 8/12/2026, 12:05:03 PM
class Solution {
    public long maxRatings(int[][] units) {
        int m = units.length;
        int[] keep    = new int[m];
        int[] donated = new int[m];
        boolean[] willDonate = new boolean[m];

        for (int i = 0; i < m; i++) {
            int[] d = units[i].clone();
            Arrays.sort(d);
            keep[i] = d[0];
            donated[i] = (d.length == 1) ? 0 : d[1];
            willDonate[i] = (d.length > 1) && (donated[i] >= keep[i]);
        }

        long totalContrib = 0;
        int[] minDon = new int[m];
        for (int i = 0; i < m; i++) {
            if (willDonate[i]) {
                totalContrib += donated[i];
                minDon[i] = keep[i];
            } else {
                totalContrib += keep[i];
                minDon[i] = Integer.MAX_VALUE;
            }
        }

        int[] prefMin = new int[m + 1];
        int[] sufMin  = new int[m + 1];
        prefMin[0] = Integer.MAX_VALUE;
        sufMin[m]  = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++)
            prefMin[i + 1] = Math.min(prefMin[i], minDon[i]);
        for (int i = m - 1; i >= 0; i--)
            sufMin[i] = Math.min(sufMin[i + 1], minDon[i]);

        long best = 0;

        for (int r = 0; r < m; r++) {
            long sum = totalContrib;
            if (willDonate[r]) {
                sum -= donated[r];
            } else {
                sum -= keep[r];
            }
            int globalMinDon = Math.min(prefMin[r], sufMin[r + 1]);

            int rRating;
            if (globalMinDon == Integer.MAX_VALUE) {
                rRating = keep[r];
            } else {
                rRating = Math.min(keep[r], globalMinDon);
            }
            sum += rRating;
            best = Math.max(best, sum);
        }

        long noTransfer = 0;
        for (int i = 0; i < m; i++) noTransfer += keep[i];
        best = Math.max(best, noTransfer);

        return best;
    }
}