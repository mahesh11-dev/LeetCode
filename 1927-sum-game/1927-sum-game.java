class Solution {
    public boolean sumGame(String num) {
        int n = num.length();
        int leftKnownSum = 0;
        int rightKnownSum = 0;
        int leftQnMarkCount = 0;
        int rightQnMarkCount = 0;
        for (int i = 0; i < n; i++) {
            char ch = num.charAt(i);
            if (ch == '?') {
                if (i < n / 2) {
                    leftQnMarkCount++;
                } else {
                    rightQnMarkCount++;
                }
            } else {
                int digit = ch - '0';
                if (i < n / 2) {
                    leftKnownSum += digit;
                } else {
                rightKnownSum += digit;
                }
            }
        }
        int totalQnmarks = leftQnMarkCount + rightQnMarkCount;

        if (totalQnmarks % 2 != 0) {
            return true;
        }

        int Left = 2 * leftKnownSum + 9 * leftQnMarkCount;
        int Right = 2 * rightKnownSum + 9 * rightQnMarkCount;

        if (Left == Right) {
            return false;
        }

        return true;
    }
}