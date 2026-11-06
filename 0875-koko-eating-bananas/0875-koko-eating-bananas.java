class Solution {
    private int hours(int[] piles, int mid){
        int n = piles.length;
        int totalHours = 0;
        for(int j=0; j<n; j++){
            totalHours += Math.ceil((double)piles[j] / mid);
        }
        return totalHours;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int maxBanana = Integer.MAX_VALUE;
        int max = piles[0];
        for(int i=1; i<piles.length; i++){
            max = Math.max(max, piles[i]);
        }
        int low = 1;
        int high = max;
        while(low <= high){
            int mid = (high - low)/2 + low;
            if(hours(piles, mid) <= h){
                maxBanana = Math.min(maxBanana, mid);
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return maxBanana;
    }
}