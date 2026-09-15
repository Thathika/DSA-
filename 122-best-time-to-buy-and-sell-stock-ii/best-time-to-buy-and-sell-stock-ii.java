class Solution {
    public int maxProfit(int[] prices) {
        int maxi=0;
        for(int i=0;i<prices.length-1;i++){
            int ans=0;
            int a=prices[i];
            int b=prices[i+1];
            
            if(a<b){
                ans=b-a;

            }
            maxi+=ans;
        }
        return maxi;
        
    }
}