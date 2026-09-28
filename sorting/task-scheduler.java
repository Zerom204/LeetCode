class Solution {
    class pair{
        int freq;
        char ch;
        pair(int f,char c){
            freq=f;
            ch=c;
        }
    }
    public int leastInterval(char[] tasks, int gap) {
        int n=tasks.length;
        HashMap<Character,Integer> map=new HashMap<>();
        HashMap<Character,Integer> free=new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(tasks[i],map.getOrDefault(tasks[i],0)+1);
            free.put(tasks[i],1);
        }
        PriorityQueue<pair> pq=new PriorityQueue<>((a,b)->{
            if(a.freq!=b.freq){
                return b.freq-a.freq;
            }
            return b.ch-a.ch;
        });
        for(char i:map.keySet()){
            pq.offer(new pair(map.get(i),i));
        }
        int seat=1;
        while(!pq.isEmpty()){
            ArrayList<pair> pulled=new ArrayList<>();
            while(!pq.isEmpty()){
                pair p=pq.poll();
                int freq=p.freq;
                char child=p.ch;
                if(free.get(child)<=seat){
                    if(p.freq>1){
                        pq.offer(new pair(freq-1,child));
                    }
                    free.put(child,seat+gap+1);
                    break;
                }
                else{
                    pulled.add(p);
                }
            }
            for(int i=0;i<pulled.size();i++){
                pq.offer(pulled.get(i));
            }
            seat++;
        }
        return seat-1;
    }
}