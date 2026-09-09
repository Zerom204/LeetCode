class Solution {
    public int hours(int speed,int[] a){
        int hours=0;
        for(int i=0;i<a.length;i++){
            hours+=a[i]/speed;
            if(a[i]%speed!=0){
                hours++;
            }
        }
        return hours;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int lb=1;
        int n=piles.length;
        int ub=Arrays.stream(piles).max().getAsInt();
        int res=0;

        while(lb<=ub){
            int guess=(lb+ub)/2;
            if(hours(guess,piles)<=h){
                res=guess;
                ub=guess-1;
            }
            else{
                lb=guess+1;
            }
        }
        return res;
    }
}