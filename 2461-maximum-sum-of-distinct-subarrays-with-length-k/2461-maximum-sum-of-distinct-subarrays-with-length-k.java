class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long maxSum = 0;
        long sum = 0;
        int i = 0, j = 0;
        HashSet<Integer> set = new HashSet<>();
        while(j < n){
            while(set.contains(nums[j])){
                sum -= nums[i];
                set.remove(nums[i]);
                i++;
            }
            set.add(nums[j]);
            sum += nums[j];
            if((j-i+1) == k){
                maxSum = Math.max(maxSum, sum);
                sum -= nums[i];
                set.remove(nums[i]);
                i++;
            }
            j++;
        }
        return maxSum;
    }
}