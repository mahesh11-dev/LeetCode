class Solution {
    private String makePalindrome(char[] left, int middle) {
        StringBuilder result = new StringBuilder();

        for (char ch : left) {
            result.append(ch);
        }

        if (middle != -1) {
            result.append((char) ('a' + middle));
        }

        for (int i = left.length - 1; i >= 0; i--) {
            result.append(left[i]);
        }

        return result.toString();
    }

    public String lexPalindromicPermutation(String s, String target) {

        int n = s.length();

        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        // Check whether a palindrome is possible
        int odd = 0;
        int middle = -1;

        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 != 0) {
                odd++;
                middle = i;
            }
        }

        if (odd > 1) {
            return "";
        }

        int half = n / 2;

        // Frequency of characters for the left half
        int[] halfFreq = new int[26];

        for (int i = 0; i < 26; i++) {
            halfFreq[i] = freq[i] / 2;
        }

        char[] left = new char[half];

        // Match target's first half as much as possible
        int matched = 0;

        while (matched < half) {

            int ch = target.charAt(matched) - 'a';

            if (halfFreq[ch] == 0) {
                break;
            }

            left[matched] = target.charAt(matched);
            halfFreq[ch]--;

            matched++;
        }

        /*
         * Case 1:
         * We matched the complete first half.
         *
         * The palindrome formed using exactly that half
         * might already be greater than target.
         */
        if (matched == half) {

            String same = makePalindrome(left, middle);

            if (same.compareTo(target) > 0) {
                return same;
            }
        }

        /*
         * Now find the smallest first-half string
         * that is greater than target's first half.
         *
         * If matching stopped early, we can try increasing
         * from the first unmatched position.
         *
         * If matching completed, start from the last position.
         */
        int start = matched == half ? half - 1 : matched;

        for (int pos = start; pos >= 0; pos--) {

            // Restore the character at pos if it was matched
            if (pos < matched) {
                halfFreq[left[pos] - 'a']++;
            }

            int curr = target.charAt(pos) - 'a';

            // Find the smallest character > target[pos]
            for (int ch = curr + 1; ch < 26; ch++) {

                if (halfFreq[ch] == 0) {
                    continue;
                }

                char[] newLeft = new char[half];

                // Keep prefix unchanged
                for (int i = 0; i < pos; i++) {
                    newLeft[i] = left[i];
                }

                // Make this position greater
                newLeft[pos] = (char) ('a' + ch);
                halfFreq[ch]--;

                // Fill remaining positions with smallest chars
                int idx = pos + 1;

                for (int x = 0; x < 26; x++) {
                    while (halfFreq[x] > 0) {
                        newLeft[idx++] = (char) ('a' + x);
                        halfFreq[x]--;
                    }
                }

                return makePalindrome(newLeft, middle);
            }
        }

        return "";
    }
}