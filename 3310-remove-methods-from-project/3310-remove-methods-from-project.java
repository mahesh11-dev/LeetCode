class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        int[] indegree = new int[n];

        for (int[] edge : invocations) {
            int u = edge[0];
            int v = edge[1];

            graph.get(u).add(v);
            indegree[v]++;
        }

        boolean[] suspicious = new boolean[n];

        Queue<Integer> q = new LinkedList<>();
        q.offer(k);
        suspicious[k] = true;

        while (!q.isEmpty()) {
            int u = q.poll();

            for (int v : graph.get(u)) {
                indegree[v]--;          // remove edge u -> v

                if (!suspicious[v]) {
                    suspicious[v] = true;
                    q.offer(v);
                }
            }
        }

        // If any suspicious node still has indegree,
        // it means some outside node points to it.
        for (int i = 0; i < n; i++) {
            if (suspicious[i] && indegree[i] > 0) {
                List<Integer> ans = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    ans.add(j);
                }
                return ans;
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!suspicious[i]) {
                ans.add(i);
            }
        }

        return ans;
    }
}