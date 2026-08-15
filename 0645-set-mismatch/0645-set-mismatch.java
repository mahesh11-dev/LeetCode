class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        long s1n = (long)n*(n+1)/2;
        long s2n = (long)n*(n+1)*(2*n+1)/6;
        long s1 = 0;
        long s2 = 0;
        for(int i=0; i<n; i++){
            s1 += (long)nums[i];
            s2 += (long)nums[i]*nums[i];
        }
        long val1 = (long)s1 - s1n;
        long val2 = (long)s2 - s2n; 
        val2 = val2 / val1;
        int repeating = (int)(val1 + val2)/2;
        int missing = (int)val2 - repeating;
        return new int[]{repeating,missing};
    }
}