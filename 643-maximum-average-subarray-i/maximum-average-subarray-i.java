class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double n=nums.length;
        double oldsum=0;
        double newsum=0;
        for(int i=0;i<k;i++){
            oldsum+=nums[i];
        }
        double maxi=oldsum;
        int left=0;
        int right=k;
        int p=0;
        newsum=oldsum;
        
        
        while(right<n){
            newsum+=-nums[left]+nums[right];
           
            if(newsum>maxi){
                maxi=newsum;
            }
            left++;
            right++;
            p++;
        }
        double l=maxi/k;
        return l;
        
    }
}