class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;
        for(int i=0; i<nums.length; i++){
            int n = nums[i];
            int len = 0;
            while(n != 0){
                len++;
                n /= 10;
            }
            if(len  % 2 == 0){
                count++;
            }
        }
        return count;
    }
}