class Solution {
    public int fib(int n) {
        if(n==0||n==1){
            return n;
        }
        int a1=fib(n-1);
        int a2=fib(n-2);
        int ans=a1+a2;
        return ans;
    }
}