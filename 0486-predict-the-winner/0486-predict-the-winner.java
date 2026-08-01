class Solution {
    public static int solve(int[] nums, int i, int j){
        if(i > j){
            return 0;
        }
        if(i == j){
            return nums[i];
        }
        int take_i = nums[i] + Math.min(solve(nums, i+2, j), solve(nums, i+1, j-1));
        int take_j = nums[j] + Math.min(solve(nums, i, j-2), solve(nums, i+1, j-1));
        return Math.max(take_i, take_j);
    }
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        int totalScore = 0;
        for(int i=0; i<n; i++){
            totalScore += nums[i];
        }

        int player1 = solve(nums, 0, n-1);

        int player2 = totalScore - player1;
        return player1 >= player2;
    }
}