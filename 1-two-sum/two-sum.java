class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int[] res=new int[2];
        int n=nums.length;
        for(int i=0;i<n;i++){
            int need=target-nums[i];

            if(map.containsKey(need))   return new int[]{map.get(need),i};

            map.put(nums[i],i);
        }
        return new int[]{};

    }
}