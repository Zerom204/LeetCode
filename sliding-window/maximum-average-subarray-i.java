class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double avg=0.0;
        int low=0;
        double res=Double.MIN_VALUE;
        int high=nums.length-1;
        for(int i=low;i<k;i++){
            avg+=nums[i];
        }
        res=avg;
        for(high=k;high<nums.length;high++){
            avg=avg-nums[low]+nums[high];
            low++;
            res=Math.max(res,avg);
        }
        return (double)(res/k);
    }
}