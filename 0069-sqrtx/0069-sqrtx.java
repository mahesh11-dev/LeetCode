class Solution {
    public int mySqrt(int x) {
        int ans = 0;
        int low = 1;
        int high = x;
        while(low <= high){
            long mid = (high - low)/2 + low;
            if(mid*mid <= x){
                ans = (int)mid;
                low = (int)mid+1;
            }else{
                high = (int)mid - 1;
            }
        }
        return ans;   
    }
}