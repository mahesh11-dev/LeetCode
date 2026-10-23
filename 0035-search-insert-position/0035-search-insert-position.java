class Solution {
    public int searchInsert(int[] nums, int target) {
        // int left = 0, right = nums.length-1;
        // while(left <= right){
        //     int mid = left + (right - left) / 2;
        //     if(nums[mid] == target){
        //         return mid;
        //     }else if(nums[mid] > target){
        //         right = mid - 1;
        //     }else{
        //         left = mid + 1;
        //     }
        // }
        // return left;
        int low = 0;
        int high = nums.length - 1;
        int ans = nums.length;
        while(low <= high){
            int mid = (high - low)/2 + low;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }
}