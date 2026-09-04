class Solution {
    public int search(int[] nums, int target) {
        int ub=nums.length-1;
        int lb=0;
        while(lb<=ub){
            int mid=(ub+lb)/2;
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid]<target){
                lb=mid+1;
            }
            else{
                ub=mid-1;
            }
        }
        return -1;
        
    }
}