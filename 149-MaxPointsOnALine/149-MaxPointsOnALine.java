// Last updated: 8/12/2026, 12:13:45 PM
class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n <= 2) return n;

        int ans = 0;

        for (int i = 0; i < n; i++) {
            Map<String, Integer> map = new HashMap<>();

            for (int j = i + 1; j < n; j++) {

                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];

                int g = gcd(dx, dy);

                dx /= g;
                dy /= g;

                // normalize sign
                if (dx < 0) {
                    dx = -dx;
                    dy = -dy;
                }

                // vertical line
                if (dx == 0) {
                    dy = 1;
                }

                // horizontal line
                if (dy == 0) {
                    dx = 1;
                }

                String key = dx + "#" + dy;

                map.put(key, map.getOrDefault(key, 0) + 1);
                ans = Math.max(ans, map.get(key) + 1);
            }
        }

        return ans;
    }

    private int gcd(int a, int b) {
        if (b == 0) return Math.abs(a);
        return gcd(b, a % b);
    }
}