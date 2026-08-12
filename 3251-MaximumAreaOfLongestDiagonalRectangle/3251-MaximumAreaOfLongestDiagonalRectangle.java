// Last updated: 8/12/2026, 12:11:31 PM
class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {

        int maxDiagonal = 0;
        int maxArea = 0;

        for (int[] d : dimensions) {

            int diagonal = d[0] * d[0] + d[1] * d[1];
            int area = d[0] * d[1];

            if (diagonal > maxDiagonal ||
               (diagonal == maxDiagonal && area > maxArea)) {

                maxDiagonal = diagonal;
                maxArea = area;
            }
        }

        return maxArea;
    }
}