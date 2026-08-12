// Last updated: 8/12/2026, 12:11:16 PM
class Solution {
    public int minMovesToCaptureTheQueen(
            int a, int b,
            int c, int d,
            int e, int f) {

        // Rook -> Queen horizontally
        if (a == e) {
            if (!(c == a &&
                  d > Math.min(b, f) &&
                  d < Math.max(b, f))) {
                return 1;
            }
        }

        // Rook -> Queen vertically
        if (b == f) {
            if (!(d == b &&
                  c > Math.min(a, e) &&
                  c < Math.max(a, e))) {
                return 1;
            }
        }

        // Bishop -> Queen
        if (Math.abs(c - e) == Math.abs(d - f)) {

            // Is rook on the same diagonal?
            if (Math.abs(a - c) == Math.abs(b - d) &&
                Math.abs(a - e) == Math.abs(b - f)) {

                // Rook is between bishop and queen
                if (a > Math.min(c, e) && a < Math.max(c, e) &&
                    b > Math.min(d, f) && b < Math.max(d, f)) {

                    return 2;
                }
            }

            return 1;
        }

        return 2;
    }
}