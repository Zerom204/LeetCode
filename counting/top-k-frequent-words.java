class Solution {
    class pair{
        int first;
        String second;
        pair(int f,String s){
            first=f;
            second=s;
        }
    }
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer>map=new HashMap<>();
        PriorityQueue<pair> pq=new PriorityQueue<>((a,b)->{
            if(a.first!=b.first){
                return a.first-b.first;
            }
            return b.second.compareTo(a.second);
        });
        int n=words.length;
        for(int i=0;i<n;i++){
            map.put(words[i],map.getOrDefault(words[i],0)+1);
        }
        for(String i:map.keySet()){
            int freq=map.get(i);
            pq.offer(new pair(freq,i));
            if(pq.size()>k){
                pq.poll();
            }
        }
        List<String> ans=new ArrayList<>();
        for(int i=0;i<k;i++){
            ans.add(pq.poll().second);
        }
        Collections.reverse(ans);
        return ans;
    }
}