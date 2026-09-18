class Solution {
    int[] x={0,0,-1,1};
    int[] y={-1,1,0,0};
    public boolean valid(int i,int j,int row, int col){
        if(i<0 || i>=row || j<0 || j>=col){
            return false;
        }
        return true;
    }
    public void dfs(char[][] board,int i,int j,int row,int col){
        board[i][j]='#';
        for(int k=0;k<4;k++){
            int ni=i+x[k];
            int nj=j+y[k];
            if(valid(ni,nj,row,col)&&board[ni][nj]=='O'){
                dfs(board,ni,nj,row,col);
            }
        }
        return;

    }
    public void solve(char[][] board) {
        int row=board.length;
        int col=board[0].length;

        for(int i=0;i<row;i++){

            if(board[i][0]=='O')
            dfs(board,i,0,row,col);

            if(board[i][col-1]=='O')
            dfs(board,i,col-1,row,col);
        }

        for(int i=0;i<col;i++){

            if(board[0][i]=='O')
            dfs(board,0,i,row,col);

            if(board[row-1][i]=='O')
            dfs(board,row-1,i,row,col);
        }

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(board[i][j]=='#'){
                    board[i][j]='O';
                }
                else if(board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }

        return;
    }
}