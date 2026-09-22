class Solution {
    HashMap<Integer,Integer> map=new HashMap<>();
    public int fun(int i,int n){
        if(i==n){
            return 1;
        }
        if(i>n){
            return 0;
        }

        if(map.containsKey(i)){
            return map.get(i);
        }

        int a1=fun(i+1,n);
        int a2=fun(i+2,n);

        int ans=a1+a2;
        map.put(i,ans);
        return ans;
    }
    public int climbStairs(int n) {
        int a=fun(0,n);
        return a;
    }
}