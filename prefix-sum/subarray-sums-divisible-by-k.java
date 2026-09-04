class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n=nums.length;
        int sum=0;
        int res=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        for(int i=0;i<n;i++){
            sum+=nums[i];
            int r=sum%k;
            if(r<0){
                r=r+k;
            }
            if(map.containsKey(r)){
                res+=map.getOrDefault(r,0);
            }
            map.put(r,map.getOrDefault(r,0)+1);
        }
        return res;
    }
}