class Solution {
    private int calculateSum(int[] nums, int mid, int n){
        int sum = 0;
        for(int i=0; i<n; i++){
            sum += Math.ceil((double)nums[i]/mid);
        }
        return sum;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            max = Math.max(max, nums[i]);
        }
        //int ans = Integer.MAX_VALUE;
        int low = 1; 
        int high = max;
        while(low <= high){
            int mid = (high - low)/2 + low;
            int sum = calculateSum(nums, mid, n);
            if(sum <= threshold){
                //ans = Math.min(ans, mid);
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        //return ans;
        return low;
    }
}