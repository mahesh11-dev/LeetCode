class Solution {
    Integer[] dp;
    public int solve(int[] s, int i){
        int n = s.length;
        if(i >= n){
            return 0;
        }
        if (dp[i] != null)
            return dp[i];

        int result = s[i]-solve(s,i+1);
        if(i+1 < n){
            result = Math.max(result, s[i] + s[i+1] - solve(s,i+2));
        }
        if(i+2 < n){
            result = Math.max(result, s[i] + s[i+1] + s[i+2] - solve(s,i+3));
        }
        return dp[i] = result;
    }
    public String stoneGameIII(int[] stoneValue) {
        dp = new Integer[stoneValue.length];

        int diff = solve(stoneValue, 0);

        if(diff > 0){
            return "Alice";
        }else if(diff < 0){
            return "Bob";
        }
        return "Tie";
    }
}