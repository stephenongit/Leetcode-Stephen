// Last updated: 8/12/2026, 12:12:00 PM
class Solution {
    public String[] splitMessage(String message, int limit) {
        int n = message.length();

        int suffix = 0;

        for (int parts = 1; ; parts++) {

            if (digits(parts) * 2 + 3 >= limit)
                return new String[0];

            suffix += digits(parts);

            int total =
                    (limit * parts)
                    - (parts * (digits(parts) + 3))
                    - suffix;

            if (total < n)
                continue;

            String[] ans = new String[parts];

            int idx = 0;

            for (int i = 1; i <= parts; i++) {

                String end = "<" + i + "/" + parts + ">";

                int take = Math.min(
                        limit - end.length(),
                        n - idx
                );

                ans[i - 1] =
                        message.substring(idx, idx + take) + end;

                idx += take;
            }

            return ans;
        }
    }

    private int digits(int x) {
        if (x < 10) return 1;
        if (x < 100) return 2;
        if (x < 1000) return 3;
        if (x < 10000) return 4;
        return String.valueOf(x).length();
    }
}