class Solution {
    private int lowerBound(int[] nums, int x) {
        int low = 0; 
        int high = nums.length-1;
        int ans = nums.length;
        while(low <= high){
            int mid = (high - low)/2 + low;
            if(nums[mid] >= x){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }
    private int upperBound(int[] nums, int x) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        int ans = n;
        while(low <= high){
            int mid = (high - low)/2 + low;
            if(nums[mid] > x){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }
    public int[] searchRange(int[] nums, int target) {
        int first = lowerBound(nums, target);
        if(first == nums.length || nums[first] != target){
            return new int[]{-1,-1};
        }
        int last = upperBound(nums, target);
        return new int[]{first,last-1};
    }
}