class Solution {
    
    public boolean dfs(ArrayList<ArrayList<Integer>> adj,int node,int c,ArrayList<Integer> colors,boolean res){
        colors.set(node,c);
        for(int i=0;i<adj.get(node).size();i++){
            int neighbour=adj.get(node).get(i);
            if(colors.get(neighbour)!=-1&& colors.get(neighbour)==c){
                res=false;
            }
            if(colors.get(neighbour)==-1){
                dfs(adj,neighbour,1-c,colors,res);
            }
        }
        return res;
    }
    public boolean isBipartite(int[][] graph) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        boolean res=true;
        int v=graph.length;
        ArrayList<Integer> colors=new ArrayList<>();
        for(int i=0;i<v;i++){
            adj.add(new ArrayList<>());
            colors.add(-1);
            for(int j=0;j<graph[i].length;j++){
                adj.get(i).add(graph[i][j]);
            }
        }
        for(int i=0;i<v;i++){
            if(colors.get(i)==-1){
                res=dfs(adj,0,0,colors,res);
                if(res==false){
                    return false;
                }
            }
        }
        return res; 
    }
}