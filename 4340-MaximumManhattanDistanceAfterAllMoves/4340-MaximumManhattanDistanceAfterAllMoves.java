// Last updated: 8/12/2026, 12:04:26 PM
class Solution {
    public int maxDistance(String moves) {
        int dx = 0, dy = 0, k = 0;
        for (char c : moves.toCharArray()) {
            switch (c) {
                case 'R':
                    dx++;
                    break;
                case 'L':
                    dx--;
                    break;
                case 'U':
                    dy++;
                    break;
                case 'D':
                    dy--;
                    break;
                case '_':
                    k++;
                    break;
            }
        }
        return Math.abs(dx) + Math.abs(dy) + k;
    }
}