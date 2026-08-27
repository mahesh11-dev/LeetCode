class Solution {
    public String lexGreaterPermutation(String s, String target) {

        int n = s.length();
        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        char[] ans = new char[n];

        // Try to make target's prefix
        for (int i = 0; i < n; i++) {

            int curr = target.charAt(i) - 'a';

            // Same character is available
            if (freq[curr] > 0) {
                ans[i] = target.charAt(i);
                freq[curr]--;
            } 
            else {
                // Cannot continue matching.
                // Try to make the answer greater at this position.
                int greater = -1;

                for (int j = curr + 1; j < 26; j++) {
                    if (freq[j] > 0) {
                        greater = j;
                        break;
                    }
                }

                if (greater != -1) {
                    ans[i] = (char) ('a' + greater);
                    freq[greater]--;

                    int idx = i + 1;

                    for (int j = 0; j < 26; j++) {
                        while (freq[j] > 0) {
                            ans[idx++] = (char) ('a' + j);
                            freq[j]--;
                        }
                    }

                    return new String(ans);
                }

                break;
            }
        }

        // Backtrack to find a position we can increase
        for (int i = n - 1; i >= 0; i--) {

            // If this position wasn't matched, we cannot go further left
            if (ans[i] == 0) {
                continue;
            }

            // Put the matched character back
            freq[ans[i] - 'a']++;

            int curr = target.charAt(i) - 'a';

            // Find smallest character greater than target[i]
            int greater = -1;

            for (int j = curr + 1; j < 26; j++) {
                if (freq[j] > 0) {
                    greater = j;
                    break;
                }
            }

            if (greater != -1) {

                StringBuilder result = new StringBuilder();

                // Keep prefix same
                for (int j = 0; j < i; j++) {
                    result.append(ans[j]);
                }

                // Make it greater here
                result.append((char) ('a' + greater));
                freq[greater]--;

                // Smallest possible suffix
                for (int j = 0; j < 26; j++) {
                    while (freq[j] > 0) {
                        result.append((char) ('a' + j));
                        freq[j]--;
                    }
                }

                return result.toString();
            }
        }

        return "";
    }
}