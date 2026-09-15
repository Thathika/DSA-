class Solution {
    public int maxProfit(int[] prices) {
        int mini=prices[0];
        int maxi=0;
        for(int i=0;i<prices.length;i++){
            int ans=0;
            if(prices[i]<mini){
                mini=prices[i];
            }
            ans=prices[i]-mini;
            maxi=Math.max(ans,maxi);
        }
        return maxi;
        
    }
}