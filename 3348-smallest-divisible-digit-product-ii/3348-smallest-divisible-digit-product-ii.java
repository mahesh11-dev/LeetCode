import java.util.Arrays;

class Solution {
    public String smallestNumber(String num, long t) {
        // Step 1: Factorize t into powers of 2, 3, 5, 7
        int[] req = new int[10];
        long temp = t;
        for (int p : new int[]{2, 3, 5, 7}) {
            while (temp % p == 0) {
                req[p]++;
                temp /= p;
            }
        }
        
        if (temp > 1) return "-1"; // Prime factor > 7 impossible

        int n = num.length();
        int firstZero = num.indexOf('0');
        int limit = (firstZero == -1) ? n : firstZero;

        // Cumulative factors for prefix of num
        int[][] prefixFactors = new int[n + 1][10];
        for (int i = 0; i < limit; i++) {
            int d = num.charAt(i) - '0';
            for (int p : new int[]{2, 3, 5, 7}) {
                prefixFactors[i + 1][p] = prefixFactors[i][p];
            }
            addFactor(prefixFactors[i + 1], d);
        }

        // Step 2: Check if num itself works
        if (firstZero == -1) {
            boolean valid = true;
            for (int p : new int[]{2, 3, 5, 7}) {
                if (prefixFactors[n][p] < req[p]) {
                    valid = false;
                    break;
                }
            }
            if (valid) return num;
        }

        // Step 3: Try replacing a digit at index i from right to left
        for (int i = limit; i >= 0; i--) {
            int startDigit = (i < n) ? (num.charAt(i) - '0' + 1) : 1;

            for (int d = startDigit; d <= 9; d++) {
                int[] cur = new int[10];
                for (int p : new int[]{2, 3, 5, 7}) {
                    cur[p] = prefixFactors[i][p];
                }
                addFactor(cur, d);

                int remLen = n - 1 - i;
                int[] needed = new int[10];
                for (int p : new int[]{2, 3, 5, 7}) {
                    needed[p] = Math.max(0, req[p] - cur[p]);
                }

                if (minDigitsNeeded(needed[2], needed[3], needed[5], needed[7]) <= remLen) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(num, 0, i);
                    sb.append(d);
                    sb.append(buildSmallestSuffix(needed[2], needed[3], needed[5], needed[7], remLen));
                    return sb.toString();
                }
            }
        }

        // Step 4: Increase length if length n is insufficient
        int targetLen = n + 1;
        while (minDigitsNeeded(req[2], req[3], req[5], req[7]) > targetLen) {
            targetLen++;
        }

        return buildSmallestSuffix(req[2], req[3], req[5], req[7], targetLen);
    }

    private void addFactor(int[] factors, int d) {
        if (d == 2) factors[2]++;
        else if (d == 3) factors[3]++;
        else if (d == 4) factors[2] += 2;
        else if (d == 5) factors[5]++;
        else if (d == 6) { factors[2]++; factors[3]++; }
        else if (d == 7) factors[7]++;
        else if (d == 8) factors[2] += 3;
        else if (d == 9) factors[3] += 2;
    }

    // Returns minimum single-digits required for (c2, c3, c5, c7)
    private int minDigitsNeeded(int c2, int c3, int c5, int c7) {
        int count = c5 + c7;
        count += c3 / 2;
        int r3 = c3 % 2;

        count += c2 / 3;
        int r2 = c2 % 3;

        if (r3 == 1 && r2 == 2) count += 2; // e.g. 6 & 2 or 3 & 4
        else if (r3 == 1 || r2 > 0) count += 1;

        return count;
    }

    // Directly constructs the sorted, optimal suffix
    private String buildSmallestSuffix(int c2, int c3, int c5, int c7, int targetLen) {
        int d7 = c7;
        int d5 = c5;
        int d9 = c3 / 2;
        int r3 = c3 % 2;

        int d8 = c2 / 3;
        int r2 = c2 % 3;

        int d6 = 0, d4 = 0, d3 = 0, d2 = 0;

        if (r3 == 1 && r2 == 2) {
            d6 = 1; d2 = 1; // 6 and 2 (sorted: 2, 6)
        } else if (r3 == 1 && r2 == 1) {
            d6 = 1;
        } else if (r3 == 1 && r2 == 0) {
            d3 = 1;
        } else if (r3 == 0 && r2 == 2) {
            d4 = 1;
        } else if (r3 == 0 && r2 == 1) {
            d2 = 1;
        }

        StringBuilder digits = new StringBuilder();
        for (int i = 0; i < d2; i++) digits.append('2');
        for (int i = 0; i < d3; i++) digits.append('3');
        for (int i = 0; i < d4; i++) digits.append('4');
        for (int i = 0; i < d5; i++) digits.append('5');
        for (int i = 0; i < d6; i++) digits.append('6');
        for (int i = 0; i < d7; i++) digits.append('7');
        for (int i = 0; i < d8; i++) digits.append('8');
        for (int i = 0; i < d9; i++) digits.append('9');

        int ones = targetLen - digits.length();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < ones; i++) res.append('1');
        res.append(digits);

        return res.toString();
    }
}