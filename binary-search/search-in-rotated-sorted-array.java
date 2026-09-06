class Solution {
    public int search(int[] nums, int target) {
        int lb=0;
        int ub=nums.length-1;
        int n=nums.length-1;
        while(lb<=ub){
            int mid=(lb+ub)/2;
            if(nums[mid]==target){
                return mid;
            }
            if(nums[mid]>=nums[n]){
                if(nums[mid]<target){
                    lb=mid+1;
                }
                else{
                    if(nums[0]>target){
                        lb=mid+1;
                    }
                    else{
                        ub=mid+1;
                    }
                }
            }
            if(nums[mid]<=nums[0]){
                if(nums[mid]>target){
                    ub=mid-1;
                }
                else{
                    if(nums[n]<target){
                        ub=mid-1;
                    }
                    else{
                        lb=mid+1;
                    }
                }
            }
        }
        return -1;
        
    }
}