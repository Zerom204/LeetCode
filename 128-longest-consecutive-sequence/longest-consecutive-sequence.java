class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            set.add(nums[i]);
        }
        int res=0;
        for(int num: set){
            if(!set.contains(num-1)){
                int x=num;
                int count=1;
                while(set.contains(x+1)){
                    x=x+1;
                    count++;
                }
                res=Math.max(count,res);
            }
        }
        return res;
    }
}