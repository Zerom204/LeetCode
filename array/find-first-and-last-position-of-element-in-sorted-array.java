class Solution {
    public int[] searchRange(int[] nums, int target) {
        int pos[]=new int[2];
        pos[0]=-1;
        pos[1]=-1;

        int ub=nums.length-1;
        int lb=0;
         //find first
        while(lb<=ub){
            int mid=(lb+ub)/2;

            if(nums[mid]==target){
                pos[0]=mid;
                ub=mid-1;
            }
            else if(nums[mid]<target){
                lb=mid+1;
            }
            else{
                ub=mid-1;
            }

        }

        ub=nums.length-1;
        lb=0;
        //find last
        while(lb<=ub){
            int mid=(lb+ub)/2;

            if(nums[mid]==target){
                pos[1]=mid;
                lb=mid+1;
            }
            else if(nums[mid]<target){
                lb=mid+1;
            }
            else{
                ub=mid-1;
            }

        }
        return pos;
        
    }
}