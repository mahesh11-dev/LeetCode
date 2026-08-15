class Solution {
    public int longestSubsequence(int[] nums) {
        int n = nums.length;
        int xor = 0;
        boolean allZero = true;
        for(int num : nums){
            xor = xor ^ num;
            if(num != 0){
                allZero = false;
            }
        }
        if(xor == 0 && allZero){
            return 0;
        }else if(xor == 0){
            return n-1;
        }
        return n;
    }
}