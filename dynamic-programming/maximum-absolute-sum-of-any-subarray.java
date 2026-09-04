class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int min=nums[0];
        int max=nums[0];
        int best1=nums[0];
        int best2=nums[0];
        int ans=Math.abs(nums[0]);
        for(int i=1;i<nums.length;i++){
            int v1=best1+nums[i];
            int v2=nums[i];
            best1=Math.min(v1,v2);
            min=Math.min(min,best1);
            int v3=best2+nums[i];
            int v4=nums[i];
            best2=Math.max(v3,v4);
            max=Math.max(max,best2);
            ans=Math.max(Math.abs(min),Math.abs(max));
        }
        return ans;
        
    }
}