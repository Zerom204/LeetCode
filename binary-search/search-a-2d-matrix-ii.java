class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;
        int n=matrix[0].length;

        int row=m-1;
        int column=0;

        while(row>=0&&column<n){
            int guess=matrix[row][column];
            if(guess>target){
                row--;
            }
            else if(guess<target){
                column++;
            }
            if(guess==target){
                return true;
            }
        }
        return false;
    }
}