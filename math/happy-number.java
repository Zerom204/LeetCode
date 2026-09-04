class Solution {
    public int sq(int n){
        int sum=0;
        while(n!=0){
            int a=n%10;
            sum=sum+(a*a);
            n=n/10;
        }
        return sum;
    }
    public boolean isHappy(int n) {
        int slow=n;
        int fast=n;

        while(fast!=1){
            slow=sq(slow);
            fast=sq(fast);
            fast=sq(fast);
            if(slow==fast&fast!=1){
                return false;
            }
        }
        return true;        
    }
}