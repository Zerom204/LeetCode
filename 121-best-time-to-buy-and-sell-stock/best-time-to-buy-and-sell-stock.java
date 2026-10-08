class Solution {
    public int maxProfit(int[] prices) {
        int profit=0;

        int low=0;
        for(int high=1;high<prices.length;high++){
            if(prices[low]<prices[high]){
                int p=prices[high]-prices[low];
                profit=Math.max(profit,p);
            }
            else{
                low=high;
            }
        }
        return profit;
    }
}