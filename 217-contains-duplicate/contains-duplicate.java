class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int n=nums.length;

        for(int i=0;i<n;i++){
            if(map.containsKey(nums[i]))    return true;

            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        return false;
    }
}