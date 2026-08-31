class Solution {
    public int recursiveSearch(int[] nums, int low, int high, int target){
        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                return mid;
            }else if(target > nums[mid]){
                return recursiveSearch(nums,mid+1,high,target);
            }else{
                return recursiveSearch(nums,low,mid-1,target);
            }
        }
        return -1;
    }
    public int search(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        return recursiveSearch(nums,low,high,target);
    }
}