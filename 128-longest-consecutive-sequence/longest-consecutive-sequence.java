class Solution {
    public int longestConsecutive(int[] nums) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        if(nums.length==0)  return 0;
        for(int i=0;i<nums.length;i++){
            pq.offer(nums[i]);
        }
        int count=1;
        int res=1;
        int prevval=pq.poll();
        while(!pq.isEmpty()){
            int val=pq.poll();
            if(val-prevval==1){
                count++;
                prevval=val;
            }
            else if(val==prevval){
                continue;
            }
            else{
                count =1;
            }
            res=Math.max(count,res);
            prevval=val;
        }
        return res;
    }
}