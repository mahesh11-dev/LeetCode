class Solution {

    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    private long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }

    private long count(long x, int[] coins) {
        int n = coins.length;
        long total = 0;

        // Every non-empty subset of coins
        for (int mask = 1; mask < (1 << n); mask++) {

            long multiple = 1;
            int bits = 0;
            boolean overflow = false;

            for (int i = 0; i < n; i++) {

                if ((mask & (1 << i)) != 0) {
                    bits++;

                    multiple = lcm(multiple, coins[i]);

                    if (multiple > x) {
                        overflow = true;
                        break;
                    }
                }
            }

            if (overflow) {
                continue;
            }

            long value = x / multiple;

            if (bits % 2 == 1) {
                total += value;
            } else {
                total -= value;
            }
        }

        return total;
    }

    public long findKthSmallest(int[] coins, int k) {

        long low = 1;
        long high = (long) coins[0] * k;

        for (int coin : coins) {
            high = Math.min(high, (long) coin * k);
        }

        while (low < high) {

            long mid = low + (high - low) / 2;

            if (count(mid, coins) >= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}