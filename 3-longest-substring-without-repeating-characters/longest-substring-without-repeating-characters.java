class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        int n=s.length();
        int res=0;
        int left=0;
        int length=0;

        for(int right=0;right<n;right++){
            char ch=s.charAt(right);
            map.put(ch,map.getOrDefault(ch,0)+1);
            length=right-left+1;
            while(map.size()<length){
                char c=s.charAt(left);
                map.put(c,map.get(c)-1);
                if(map.get(c)==0)   map.remove(c);
                left++;
                length=right-left+1;
            }
            length=right-left+1;
            res=Math.max(res,length);
        }
        return res;
    }
}