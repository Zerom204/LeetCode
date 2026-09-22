class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        int res[]=new int[n];
        Stack<Integer> s=new Stack<>();
        s.push(nums[n-1]);
        for(int i=n-2;i>=0;i--){
            s.push(nums[i]);
        }
        for(int i=n-1;i>=0;i--){
            while(!s.isEmpty()&& s.peek()<=nums[i]){
                s.pop();
            }
            if(s.isEmpty()){
                res[i]=-1;
            }
            else{
                res[i]=s.peek();
            }
            s.push(nums[i]);
        }
        return res;
    }
}