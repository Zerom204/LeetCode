class Solution {
    class pair{
        int weight;
        int node;
        pair(int weight,int node){
            this.weight=weight;
            this.node=node;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        
        k--;

        int ans=0;
        ArrayList<ArrayList<pair>> adj=new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<times.length;i++){
            int src=times[i][0];
            int dest=times[i][1];
            int weight=times[i][2];
            adj.get(src-1).add(new pair(weight,dest-1));
        }

        PriorityQueue<pair> pq=new PriorityQueue<>((a,b)-> a.weight-b.weight);

        ArrayList<Integer> dist=new ArrayList<>();

        for(int i=0;i<n;i++){
            dist.add(Integer.MAX_VALUE);
        }

        pq.offer(new pair(0,k));
        dist.set(k,0);

        while(!pq.isEmpty()){
            pair p=pq.poll();
            int d=p.weight;
            int node=p.node;

            if(d>dist.get(node)) continue;

            for(pair j:adj.get(node)){
                int wt=j.weight;
                int neighbour=j.node;
                
                if(d+wt<dist.get(neighbour)){
                    dist.set(neighbour,d+wt);
                    pq.offer(new pair(d+wt,neighbour));
                }
            }
        }

        for(int i:dist){
            if(i!=Integer.MAX_VALUE)
            ans=Math.max(ans,i);
            else return -1;
        }

        return ans;
    }
}