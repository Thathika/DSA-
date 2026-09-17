class Solution {
    public int numOfSubarrays(int[] arr, int k, int t) {
        int n =arr.length;
        int sum=0;
        int fullsum=0;
        int count=0;
        int avg=0;
        for(int i=0;i<k;i++){
            sum+=arr[i];
        }
        avg=sum/k;
        if(avg>=t) count=1;
        int left=0;
        int right=k;
        fullsum=sum;
        while(right<n){
            int p=0;
            fullsum+=-arr[left]+arr[right];
            p=fullsum/k;
            if(p>=t) count++;
            right++;
            left++;
        }
        return count;
        
    }
}