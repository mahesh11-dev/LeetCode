class Solution {
    private int calculateDays(int weights[], int n, int capacity){
        int sum = 0;
        int day = 0;
        for(int i=0; i<n; i++){
            sum += weights[i];
            if(sum > capacity){
                day++;
                sum = weights[i];
            }
            if(i == n-1 && sum <= capacity){
                day++;
            }
        }
        return day;
    }
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            sum += weights[i];
            max = Math.max(max, weights[i]);
        }
        int low = max;
        int high = sum;
        int ans = Integer.MAX_VALUE;
        while(low <= high){
            int mid = (high - low)/2 + low;
            int day = calculateDays(weights, n, mid);
            if(day <= days){
                ans = Math.min(ans, mid);
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }
}