class Solution {
    class pair{
        int freq;
        int num;
        pair(int freq,int num){
            this.freq=freq;
            this.num=num;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        int res[]=new int[k];
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        PriorityQueue<pair> pq=new PriorityQueue<>((a,b)->{
            if(b.freq!=a.freq){
                return b.freq-a.freq;
            }
            return a.num-b.num;
        });

        for(int key:map.keySet()){
            pq.offer(new pair(map.get(key),key));
        }
        for(int i=0;i<k;i++){
            pair p=pq.poll();
            res[i]=p.num;
        }
        return res;
    }
}