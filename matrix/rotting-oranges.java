class Solution {
    public boolean valid(int i,int j,int n, int m){

        if(i<0 || i>=n || j<0 || j>=m){
            return false;
        }

        return true;
    }
    public int orangesRotting(int[][] grid) {

        int n=grid.length;
        int m=grid[0].length;
        int fresh=0;
        int time=0;
        int[] x={0,0,-1,1};
        int[] y={-1,1,0,0};
        Queue<int[]> q=new LinkedList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                    grid[i][j]=-2;
                }
                else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }

        while(!q.isEmpty() && fresh>0){
            time++;
            int s=q.size();
            while(s>0){
                int[] current=q.poll();
                int row=current[0];
                int col=current[1];
                for(int i=0;i<4;i++){
                    int newrow=row+x[i];
                    int newcol=col+y[i];
                    if(valid(newrow,newcol,n,m)&& grid[newrow][newcol]==1){
                        fresh--;
                        grid[newrow][newcol]=-2;
                        q.add(new int[]{newrow,newcol});
                    }
                }
                s--;
            }
        }

        if(fresh>0){
            return -1;
        }

        return time;
    }
}