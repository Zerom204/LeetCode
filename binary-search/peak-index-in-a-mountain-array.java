class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int lb=0;
        int ub=arr.length-1;
        int res=0;
        while(lb<=ub){
            int mid =(lb+ub)/2;
            if(arr[mid+1]>arr[mid]){
                lb=mid+1;
            }
            else{
                res=mid;
                ub=mid-1;
            }
        }
        return res;
    }
}