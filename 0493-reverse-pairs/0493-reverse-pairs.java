class Solution {
    public int mergeSortFun(int[] nums, int low, int high){
        int count = 0;
        if(low == high){
            return count;
        }
        int mid = (low + high)/2;
        count += mergeSortFun(nums, low, mid);
        count += mergeSortFun(nums, mid+1, high);
        count += countPairs(nums, low, mid, high);
        merge(nums, low, mid, high);
        return count;
    }
    public void merge(int[] nums, int low, int mid, int high){
        ArrayList<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid+1;
        while(left <= mid && right <= high){
            if(nums[left] <= nums[right]){
                temp.add(nums[left]);
                left++;
            }else{
                temp.add(nums[right]);
                //if(nums[left] > 2*nums[right]){
                //    count += (right - (mid+1));
                //}
                right++;
            }
        }
        while(left <= mid){
            temp.add(nums[left++]);
        }
        while(right <= high){
            temp.add(nums[right++]);
        }
        for(int i=low; i<=high; i++){
            nums[i] = temp.get(i-low);
        }
    }
    public int countPairs(int[] nums, int low, int mid, int high){
        int count = 0;
        int right = mid + 1;
        for(int i=low; i<=mid; i++){
            while(right <= high && nums[i] > 2L*nums[right]){
                right++;
            }
            count += (right - (mid+1));
        }
        return count;
    }
    public int reversePairs(int[] nums) {
        return mergeSortFun(nums, 0, nums.length-1);
    }
}