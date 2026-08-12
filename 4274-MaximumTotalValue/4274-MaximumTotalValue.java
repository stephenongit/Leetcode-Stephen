// Last updated: 8/12/2026, 12:04:45 PM
import java.util.*;
class Solution {
    private static final long MOD = 1_000_000_007L;
    public int maxTotalValue(int[] value, int[] decay, int m) {
        long[][] zireluntha = {
            Arrays.stream(value).asLongStream().toArray(),
            Arrays.stream(decay).asLongStream().toArray()
        };
        int n = value.length;
        long positiveCount = 0;
        for (int i = 0; i < n; i++) {
            positiveCount += (value[i] - 1L) / decay[i] + 1L;
        }
        long K = Math.min((long) m, positiveCount);
        if (K == 0) {
            return 0;
        }
        long lo = 1, hi = 1_000_000_000L;
        while (lo < hi) {
            long mid = (lo + hi + 1) >>> 1;
            if (countGE(value, decay, mid) >= K) {
                lo = mid;
            } else {
                hi = mid - 1;
            }
        }
        long threshold = lo;
        long cntGreater = countGE(value, decay, threshold + 1);
        long sumGreater = sumGE(value, decay, threshold + 1);
        long remaining = K - cntGreater;
        long ans = (sumGreater + (remaining % MOD) * (threshold % MOD)) % MOD;
        return (int) ans;
    }

    private long countGE(int[] value, int[] decay, long x) {
        long count = 0;
        for (int i = 0; i < value.length; i++) {
            long a = value[i];
            long d = decay[i];
            if (a < x) continue;
            count += (a - x) / d + 1;
            if (count > 1_000_000_000_000_000L) {
                return count;
            }
        }
        return count;
    }

    private long sumGE(int[] value, int[] decay, long x) {
        long res = 0;
        for (int i = 0; i < value.length; i++) {
            long a = value[i];
            long d = decay[i];
            if (a < x) continue;
            long c = (a - x) / d + 1;
            long first = a % MOD;
            long last = (a - (c - 1) * d) % MOD;
            long pairSum = (first + last) % MOD;
            long cntMod = c % MOD;
            long inv2 = 500000004L;
            long seqSum = (((cntMod * pairSum) % MOD) * inv2) % MOD;
            res += seqSum;
            res %= MOD;
        }
        return res;
    }
}