class Solution {
    int count=0;
    public void countpairs(int nums[],int low,int mid,int high){
        int right=mid+1;
        for(int i=low;i<=mid;i++){
            while(right<=high && (long)nums[i]>2L*nums[right]) right++;
            count+=right-(mid+1);
        }
    }
    public void merge(int nums[],int low,int mid,int high){
        ArrayList<Integer> temp=new ArrayList<>();
        int left=low;
        int right=mid+1;

        while(left<=mid && right<=high){
            if(nums[left]<nums[right]){
                temp.add(nums[left]);
                left++;
            }
            else{
                temp.add(nums[right]);
                right++;
            }
        }
        while(left<=mid){
            temp.add(nums[left]);
            left++;
        }
        while(right<=high){
            temp.add(nums[right]);
            right++;
        }
        for(int i=low;i<=high;i++){
            nums[i]=temp.get(i-low);
        }
    }
    public void mergesort(int nums[],int low,int high){
        if(low >= high) return;
        int mid=(low+high)/2;
        mergesort(nums,low,mid);
        mergesort(nums,mid+1,high);
        countpairs(nums,low,mid,high);
        merge(nums,low,mid,high);
    }
    public int reversePairs(int[] nums) {
        int n=nums.length-1;
        mergesort(nums,0,n);
        return count;
    }
}