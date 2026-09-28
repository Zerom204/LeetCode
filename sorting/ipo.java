class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n=profits.length;
        ArrayList<int[]> proj=new ArrayList<>();
        for(int i=0;i<n;i++){
            proj.add(new int[]{capital[i],profits[i]});
        }
        proj.sort((a,b)->a[0]-b[0]);
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        int idx=0;
        while(k>0){
            while(idx<n){
                if(proj.get(idx)[0]>w){
                    break;
                }
                pq.offer(proj.get(idx)[1]);
                idx++;
            }
            if(pq.isEmpty()){
                return w;
            }
            w=w+pq.poll();
            k--;
        }
        return w;
    }
}