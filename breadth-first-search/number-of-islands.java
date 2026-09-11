class Solution {
    public boolean valid(int i,int j, int n, int m){

        if(i<0 || i>=n || j<0 || j>=m){
            return false;
        }

        return true;
    }
    void dfs(char[][] grid, int n, int m, boolean[][] visited, int[] x, int[] y, int i, int j){

        visited[i][j]=true;

        for(int k=0;k<4;k++){
            int row=i+x[k];
            int col=j+y[k];
            if(valid(row,col,n,m) && !visited[row][col] && grid[row][col]=='1'){
                dfs(grid,n,m,visited,x,y,row,col);
            } 
        }

        return;
    }
    public int numIslands(char[][] grid) {

        int n=grid.length;
        int m=grid[0].length;
        int res=0;
        boolean[][] visited=new boolean[n][m];
        int[] x={-1,1,0,0};
        int[] y={0,0,-1,1};

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1'&& !visited[i][j]){
                    dfs(grid,n,m,visited,x,y,i,j);
                    res++;
                }
            }
        }

        return res;
    }
}