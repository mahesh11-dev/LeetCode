class Solution {
    int[][] dp;
    private int solve(int left, int right, int[] preSum){
        if(left >= right){
            return 0;
        }
        if (dp[left][right] != -1) {
            return dp[left][right];
        }
        int score = 0;
        for(int mid=left; mid<=right-1; mid++){
            
            int leftSum = preSum[mid] - (left-1 >= 0 ? preSum[left-1] : 0);
            int rightSum = preSum[right] - preSum[mid];

            if(leftSum < rightSum){
                score = Math.max(score, solve(left, mid, preSum)+leftSum);
            }else if(leftSum > rightSum){
                score = Math.max(score, solve(mid+1, right, preSum)+rightSum);
            }else{
                score = Math.max(score, Math.max(solve(left, mid, preSum)+leftSum, solve(mid+1, right, preSum)+rightSum));
            }
        }
        return dp[left][right] = score;
    }
    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        int[] preSum = new int[n];
        preSum[0] = stoneValue[0];
        for(int i=1; i<n; i++){
            preSum[i] = preSum[i-1]+stoneValue[i];
        }
        dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solve(0, n-1, preSum);
    }
}