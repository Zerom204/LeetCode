class Solution {
    public int maxSubArray(int[] nums){
        int ans=nums[0];
        int best=nums[0];
        int n=nums.length;
        for(int i=1;i<n;i++){
            int v1=best+nums[i];
            int v2=nums[i];
            best=Math.max(v1,v2);
            ans=Math.max(ans,best);
        }
        return ans;
    }
}