class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int bestBuy = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int i=0; i<n; i++){
            if(prices[i] < bestBuy){
                bestBuy = prices[i];
            }else{
                maxProfit = Math.max(maxProfit, prices[i] - bestBuy);
            }
        }
        return maxProfit;
    }
}