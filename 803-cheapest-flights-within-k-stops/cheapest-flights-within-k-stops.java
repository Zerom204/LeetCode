class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        ArrayList<Integer> res=new ArrayList<>();

        for(int i=0;i<n;i++){
            res.add(Integer.MAX_VALUE);
        }
        res.set(src,0);
        for(int i=0;i<=k;i++){
            ArrayList<Integer> temp=new ArrayList<>(res);
            for(int j=0;j<flights.length;j++){
                int s=flights[j][0];
                int d=flights[j][1];
                int w=flights[j][2];

                if(res.get(s)!=Integer.MAX_VALUE && temp.get(d)>res.get(s)+w)    
                temp.set(d,res.get(s)+w);
            }
            res=temp;
        }
        if(res.get(dst)==Integer.MAX_VALUE) return -1;
        return res.get(dst);
    }
}