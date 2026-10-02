class Solution {
    class triplet{
        int efforts;
        int row;
        int column;
        triplet(int e,int r,int c){
            efforts=e;
            row=r;
            column=c;
        }
    }
    public boolean valid(int r,int c, int n,int m){
        if(r<0 || r>=n || c<0 || c>=m) return false;
        return true;
    }
    public int minimumEffortPath(int[][] heights) {
        int n=heights.length;
        int m=heights[0].length;

        int[][] res=new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                res[i][j]=Integer.MAX_VALUE;
            }
        }

        PriorityQueue<triplet> pq=new PriorityQueue<>((a,b)->a.efforts-b.efforts);

        int x[]={1,-1,0,0};
        int y[]={0,0,1,-1};

        res[0][0]=0;
        pq.offer(new triplet(0,0,0));

        while(!pq.isEmpty()){
            triplet p=pq.poll();
            int row=p.row;
            int col=p.column;
            int dist=p.efforts;

            if(dist>res[row][col]) continue;

            for(int k=0;k<4;k++){
                int r=row+x[k];
                int c=col+y[k];

                if(!valid(r,c,n,m)) continue;
                int absdiff=Math.abs(heights[row][col]-heights[r][c]);
                int newwt=Math.max(absdiff,dist);
                if(newwt<res[r][c]){
                    res[r][c]=newwt;
                    pq.offer(new triplet(newwt,r,c));
                }
            }
        }
        return res[n-1][m-1];
    }
}