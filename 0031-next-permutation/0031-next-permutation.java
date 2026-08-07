class Solution {
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    private void reverse(int[] nums, int st, int end){
        while(st < end){
            swap(nums, st, end);
            st++;
            end--;
        }
    }
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int pivotIdx = -1;
        for(int i=n-2; i>=0; i--){
            if(nums[i] < nums[i+1]){
                pivotIdx = i;
                break;
            }
        }
        if(pivotIdx == -1){
            reverse(nums, 0, n-1);
            return;
        }
        //rightMost
        for(int i=n-1; i>pivotIdx; i--){
            if(nums[i] > nums[pivotIdx]){
                swap(nums, i, pivotIdx);
                break;
            }
        }
        reverse(nums, pivotIdx+1, n-1);
    }
}