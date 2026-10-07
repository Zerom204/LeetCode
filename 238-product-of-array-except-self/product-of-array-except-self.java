class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int res[]=new int[n];
        int prefix[]=new int[n];
        prefix[0]=nums[0];
        int suffix[]=new int[n];
        suffix[n-1]=nums[n-1];
        for(int i=1;i<n;i++){
            prefix[i]=prefix[i-1]*nums[i];
            suffix[n-1-i]=suffix[n-i]*nums[n-1-i];
        }
        for(int i=0;i<n;i++){
            if(i==0){
                res[i]=suffix[i+1];
            }
            else if(i==n-1){
                res[i]=prefix[i-1];
            }
            else{
                res[i]=prefix[i-1]*suffix[i+1];
            }
        }
        return res;
    }
}