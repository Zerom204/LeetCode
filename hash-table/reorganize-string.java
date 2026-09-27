class Solution {
    class pair{
        int freq;
        char ch;
        pair(int f,char c){
            freq=f;
            ch=c;
        }
    }
    public String reorganizeString(String s) {
        int n=s.length();
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
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
        String res="";
        int seat=0;
        while(!pq.isEmpty()){
            pair p=pq.poll();
            if(seat==0||res.charAt(seat-1)!=p.ch){
                res=res+p.ch;
                seat++;
                p.freq--;
                if(p.freq>0){
                    pq.offer(p);
                }
            }
            else{
                if(pq.isEmpty()){
                    return "";
                }
                pair p2=pq.poll();
                res=res+p2.ch;
                seat++;
                p2.freq--;
                if(p2.freq>0){
                    pq.offer(p2);
                }
                pq.offer(p);               
            }
        }
        return res;
    }
}