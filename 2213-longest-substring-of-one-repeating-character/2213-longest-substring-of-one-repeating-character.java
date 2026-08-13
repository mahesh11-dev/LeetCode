class Solution {
    class Node {
        int prefix = 0;
        int suffix = 0;
        int maxLen = 0;
        char leftChar = 0;
        char rightChar = 0;

        Node() {}

        Node(int prefix, int suffix, int maxLen, char leftChar, char rightChar) {
            this.prefix = prefix;
            this.suffix = suffix;
            this.maxLen = maxLen;
            this.leftChar = leftChar;
            this.rightChar = rightChar;
        }
    }

    Node[] segTree;

    private Node merge(Node L, Node R, int leftLen, int rightLen) {

        Node result = new Node();

        result.leftChar = L.leftChar;
        result.rightChar = R.rightChar;

        // Prefix
        result.prefix = L.prefix;

        if (L.prefix == leftLen && L.rightChar == R.leftChar) {
            result.prefix = L.prefix + R.prefix;
        }

        // Suffix
        result.suffix = R.suffix;

        if (R.suffix == rightLen && L.rightChar == R.leftChar) {
            result.suffix = R.suffix + L.suffix;
        }

        // Maximum
        result.maxLen = Math.max(L.maxLen, R.maxLen);

        if (L.rightChar == R.leftChar) {
            result.maxLen = Math.max(
                result.maxLen,
                L.suffix + R.prefix
            );
        }

        return result;
    }

    private void buildSegmentTree(int i, int l, int r, String s) {

        if (l == r) {
            segTree[i] = new Node(1, 1, 1, s.charAt(l), s.charAt(l));
            return;
        }

        int mid = l + (r - l) / 2;

        buildSegmentTree(2 * i + 1, l, mid, s);
        buildSegmentTree(2 * i + 2, mid + 1, r, s);

        segTree[i] = merge(
            segTree[2 * i + 1],
            segTree[2 * i + 2],
            mid - l + 1,
            r - mid
        );
    }

    private void update(int i, int l, int r, int pos, char ch) {

        if (l == r) {
            segTree[i] = new Node(1, 1, 1, ch, ch);
            return;
        }

        int mid = l + (r - l) / 2;

        if (pos <= mid) {
            update(2 * i + 1, l, mid, pos, ch);
        } else {
            update(2 * i + 2, mid + 1, r, pos, ch);
        }

        segTree[i] = merge(
            segTree[2 * i + 1],
            segTree[2 * i + 2],
            mid - l + 1,
            r - mid
        );
    }
    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        int n = s.length();

        segTree = new Node[4 * n];

        buildSegmentTree(0, 0, n - 1, s);

        int k = queryIndices.length;
        int[] ans = new int[k];

        for (int i = 0; i < k; i++) {

            int pos = queryIndices[i];
            char ch = queryCharacters.charAt(i);

            update(0, 0, n - 1, pos, ch);

            ans[i] = segTree[0].maxLen;
        }

        return ans;
    }
}