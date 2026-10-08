class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //Sorting
        Arrays.sort(nums);
        List<List<Integer>> res=new ArrayList<>();
        int n=nums.length;

        for(int i=0;i<nums.length-2;i++){
            int sum=nums[i];

            if(i>0&&nums[i]==nums[i-1]) continue;

            int left=i+1;
            int right=n-1;

            while(left<right){
                int s=nums[left]+nums[right];
                if(s+sum==0){
                    res.add(Arrays.asList(nums[i],nums[left],nums[right]));

                    left++;
                    right--;

                    while(left<right && nums[left]==nums[left-1]){
                        left++;
                    }
                    while(right>left && nums[right]==nums[right+1]){
                        right--;
                    }
                }
                else if(sum+s<0){
                    left++;
                }
                else{
                    right--;
                }
            }
        }
        return res;
    }
}