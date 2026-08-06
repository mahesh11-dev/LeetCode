class Solution {
    public int[] rearrangeArray(int[] nums) { 
        int n = nums.length;
        int[] ans = new int[n];
        int pos = 0; //positive index
        int neg = 1; //negative index
        for(int i=0; i<n; i++){
            if(nums[i] > 0){           //positive number
                ans[pos] = nums[i];
                pos += 2;
            }else if(nums[i] < 0){     //negative number
                ans[neg] = nums[i];
                neg += 2;
            }
        }
        return ans;
    }
}