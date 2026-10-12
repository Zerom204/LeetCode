class Solution {
    public void reverse(int[] nums,int left,int right){
        while(left<right){
            int temp2=nums[left];
            nums[left]=nums[right];
            nums[right]=temp2;
            left++;
            right--;
        }
    }
    public void nextPermutation(int[] nums) {
        int n=nums.length;
        int pos=-1;
        for(int i=n-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                pos=i;
                break;
            }
        }
        if(pos==-1){
            reverse(nums,0,n-1);
        }
        else{
            int nextgreater=Integer.MAX_VALUE;
            int pos2=n-1;
            while(nums[pos2]<=nums[pos]){
                pos2--;
            }
            int temp=nums[pos2];
            nums[pos2]=nums[pos];
            nums[pos]=temp;

            int left=pos+1;
            int right=n-1;
            reverse(nums,left,right);
        }
        return;
    }
}