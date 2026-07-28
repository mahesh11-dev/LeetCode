class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int maxLen = Integer.MIN_VALUE;
        int count = 0;
        int i = 0;
        for(int j=0; j<n; j++){
            if(nums[j] == 0){
                count++;
            }
            if(count > k){
                if(nums[i] == 0){
                    count--;
                }
                i++;
            }
            if(count <= k){
                maxLen = Math.max(maxLen, j-i+1);
            }
        }
        return maxLen;
    }
}