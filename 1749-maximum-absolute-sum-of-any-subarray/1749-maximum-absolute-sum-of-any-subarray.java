class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int n = nums.length;
        int maxSum = nums[0], minSum = nums[0];
        int maxEnding = nums[0], minEnding = nums[0];
        for(int i=1; i<n; i++){
            maxEnding = Math.max(nums[i], maxEnding + nums[i]);
            maxSum = Math.max(maxSum, maxEnding);
            minEnding = Math.min(nums[i], minEnding + nums[i]);
            minSum = Math.min(minSum, minEnding);
        }
        return Math.max(Math.abs(maxSum),Math.abs(minSum));
    }
}