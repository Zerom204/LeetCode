class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        int low=0;
        int high=0;
        int res=0;
        HashMap<Character,Integer> map=new HashMap<>();

        for(high=0;high<n;high++){
            char ch=s.charAt(high);
            map.put(ch,map.getOrDefault(ch,0)+1);
            int length=high-low+1;
            
            while(map.size()<length){
                char delch=s.charAt(low);
                map.put(delch,map.get(delch)-1);
                if(map.get(delch)==0)   map.remove(delch);
                low++;
                length=high-low+1;
            }
            res=Math.max(res,length);
        }
        return res;
    }
}