class Solution {

    class pair{
        int row;
        int col;

        pair(int row,int col){
            this.row=row;
            this.col=col;
        }
    }

    public boolean valid(int row, int col, int n){
        if(row<0 || row>=n || col<0 || col>=n) return false;

        return true;
    }

    public boolean bfs(int[][] grid,int n,int guess){
        if(grid[0][0]>guess) return false;
        
        int x[]={1,-1,0,0};
        int y[]={0,0,-1,1};

        Queue<pair> q=new LinkedList<>();
        boolean visited[][]=new boolean[n][n];

        q.offer(new pair(0,0));
        visited[0][0]=true;

        while(!q.isEmpty()){
            pair p=q.poll();
            int row=p.row;
            int col=p.col;

            if(row==n-1 && col==n-1) return true;

            for(int i=0;i<4;i++){
                int r=row+x[i];
                int c=col+y[i];

                if(valid(r,c,n) && visited[r][c]!= true && guess>=grid[r][c]){
                    q.offer(new pair(r,c));
                    visited[r][c]=true;
                }
            }
        }
        return false;
    }

    public int swimInWater(int[][] grid) {
        int low=Integer.MAX_VALUE;
        int high=Integer.MAX_VALUE;
        int res=0;
        int n=grid.length;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                low=Math.min(grid[i][j],low);
                high=Math.max(grid[i][j],high);
            }
        }
        
        while(low<=high){
            int guess=(low+high)/2;
            if(bfs(grid,n,guess)){
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