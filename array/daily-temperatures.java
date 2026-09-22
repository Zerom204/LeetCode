class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n=temperatures.length;
        int[] res=new int[n];
        Stack<Integer> s=new Stack<>();
        if(n==1){
            res[0]=0;
            return res;
        }
        s.push(n-1);
        res[n-1]=0;
        for(int i=n-2;i>=0;i--){
            while(!s.isEmpty() && temperatures[s.peek()]<=temperatures[i]){
                s.pop();
            }
            if(s.isEmpty()){
                res[i]=0;
            }
            else{
                res[i]=s.peek()-i;
            }
            s.push(i);
        }
        return res;
    }
}