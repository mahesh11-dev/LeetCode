class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
         
        int minSum = nums[0];
        int sum1 = nums[0];
        int totalSum = nums[0];
        for(int i=1; i<n; i++){
            sum1 = Math.min(nums[i], sum1+nums[i]);
            minSum = Math.min(minSum, sum1);
            totalSum += nums[i];
        }
        int circularSum = totalSum - minSum;

        int maxSum = nums[0];
        int sum2 = nums[0];
        for(int i=1; i<n; i++){
            sum2 = Math.max(nums[i], sum2+nums[i]);
            maxSum = Math.max(maxSum,sum2);
        }
        if(maxSum < 0){
            return maxSum;
        }
        return Math.max(maxSum, circularSum);
    }
}