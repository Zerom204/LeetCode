class Solution {
    public void fun(int[] a,int n,int idx,ArrayList<Integer> diary,int sum,List<List<Integer>> res, int target){
        if(idx==n){
            if(sum==target){
                res.add(new ArrayList<>(diary));
            }
            return;
        }
        fun(a,n,idx+1,diary,sum,res,target);

        if(a[idx]+sum<=target){
            diary.add(a[idx]);
            sum+=a[idx];
            fun(a,n,idx,diary,sum,res,target);
            diary.remove(diary.size()-1);
            sum-=a[idx];
        }
        return;
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList<>();
        int n=candidates.length;
        fun(candidates,n,0,new ArrayList<>(),0,res,target);
        return res;
    }
}