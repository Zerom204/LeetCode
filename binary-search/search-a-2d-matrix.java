class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;
        int n=matrix[0].length;
        int high=(m*n)-1;
        int low=0;
        while(low<=high){
            int guess=(low+high)/2;
            int row=guess/n;
            int col=guess%n;
            if(matrix[row][col]==target){
                return true;
            }
            else if(matrix[row][col]<target){
                low=guess+1;
            }
            else{
                high=guess-1;
            }
        }
        return false;
    }
}