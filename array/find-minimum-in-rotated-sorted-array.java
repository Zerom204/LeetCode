class Solution {
    public int findMin(int[] nums) {
        int lb=0;
        int ub=nums.length-1;
        int n=nums.length-1;
        int res=0;
        while(lb<=ub){
            int mid=(lb+ub)/2;
            if(nums[mid]>nums[n]){
                lb=mid+1;
            }
            else{
                res=nums[mid];
                ub=mid-1;
            }
        }
        return res;
    }
}