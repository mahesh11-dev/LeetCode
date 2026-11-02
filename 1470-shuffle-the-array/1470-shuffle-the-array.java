class Solution {
    public int[] shuffle(int[] nums, int n) {
        int m = nums.length;
        int i = 0;
        int j = n;
        int[] ans = new int[m];
        int k = 0;
        while(i < n){
            ans[k++] = nums[i++];
            ans[k++] = nums[j++];
        }
        return ans;
    }
}