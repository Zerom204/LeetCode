class Solution {
    public int findMaxLength(int[] nums) {
        int n=nums.length;
        int z=0;
        int o=0;
        int res=0;
        HashMap <Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                z++;
            }
            else{
                o++;
            }
            int diff=z-o;
            if(diff==0){
                res=Math.max(res,i+1);
            }
            if(map.containsKey(diff)){
                int len=Math.abs(i-map.get(diff));
                res=Math.max(len,res);
            }else{
                map.put(diff,i);
            }
        }
        return res;
    }
}