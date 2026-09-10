class Solution {
    public int lesser(int m,int n,int guess){
        int row=m;
        int col=1;
        int count =0;
        while(row>=1&&col<=n){
            if((row*col)>guess){
                row--;
            }
            else{
                count+=row;
                col++;
            }
        }
        return count;
    }
    public int findKthNumber(int m, int n, int k) {
        int low=1;
        int high=m*n;
        int res=0;

        while(low<=high){
            int guess=(low+high)/2;
            int count=lesser(m,n,guess);
            if(count>=k){
                res=guess;
                high=guess-1;
            }
            else{
                low=guess+1;
            }
        }
        return res;
    }
}