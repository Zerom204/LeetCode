class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int maxending=nums[0];
        int min=nums[0];
        int minending=nums[0];
        int max=nums[0];
        int ans=nums[0];
        int sum=0;
        int a=0;
        for(int i=0;i<nums.length;i++){
            sum=sum+nums[i];
        }
        for(int i=1;i<nums.length;i++){
            maxending=Math.max(nums[i],maxending+nums[i]);
            max=Math.max(max,maxending);
            minending=Math.min(nums[i],minending+nums[i]);
            min=Math.min(min,minending);
        }
        a=sum-min;
        if (max < 0)
            return max;
        ans=Math.max(max,a);
        return ans;
        
    }
}