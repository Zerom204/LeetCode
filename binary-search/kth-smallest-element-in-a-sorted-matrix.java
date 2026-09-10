class Solution {
    
    public int lesser(int[][] matrix,int m,int n,int guess){
        int row=m-1;
        int col=0;
        int count =0;
        while(row>=0&&col<n){
            if(matrix[row][col]>guess){
                row--;
            }
            else{
                count+=row+1;
                col++;
            }
        }
        return count;
    }
    public int kthSmallest(int[][] matrix, int k) {
        int low=matrix[0][0];
        int m=matrix.length;
        int n=matrix[0].length;
        int high=matrix[m-1][n-1];
        int res=0;

        while(low<=high){
            int guess=(low+high)/2;
            int count=lesser(matrix,m,n,guess);
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