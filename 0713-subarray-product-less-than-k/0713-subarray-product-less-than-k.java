class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k <= 1) return 0;
        int count = 0;
        long product = 1;
        int n = nums.length;
        int i = 0;
        for(int j=0; j<n; j++){
            product *= nums[j];
            while(product >= k){
                product = product / nums[i];
                i++;
            }
            count += (j - i + 1);
        }
        return count;
    }
}