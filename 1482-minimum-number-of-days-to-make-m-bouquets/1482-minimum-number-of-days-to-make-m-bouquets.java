class Solution {
    private int countBouquets(int[] bloomDay, int n, int mid, int k){
        int count = 0;
        int bouquets = 0;
        for(int i=0; i<n; i++){
            if(bloomDay[i] <= mid){
                count++;
                if(count == k){
                    bouquets++;
                    count = 0;
                }
            }else{
                count = 0;
            }
        }
        return bouquets;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if((long)m*k > n){
            return -1;
        }
        int ans = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            min = Math.min(min, bloomDay[i]);
            max = Math.max(max, bloomDay[i]);
        }
        int low = min;
        int high = max;
        while(low <= high){
            int mid = (high - low)/2 + low;
            int bouquets = countBouquets(bloomDay, n, mid, k);
            if(bouquets >= m){
                ans = Math.min(ans, mid);
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        if(ans == Integer.MAX_VALUE){
            return -1;
        }
        return ans;
    }
}