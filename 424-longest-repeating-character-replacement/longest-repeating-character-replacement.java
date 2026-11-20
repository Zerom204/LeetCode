class Solution {
    /*public int find(int f[]){
        int max=-1;
        int n=f.length;
        for(int i=0;i<n;i++){
            max=Math.max(max,f[i]);
        }
        return max;
    }*/
    public int characterReplacement(String s, int k) {
        int n=s.length();
        int left=0;
        int res=0;
        int length=0;
        int maxfreq=0;
        HashMap<Character,Integer> map=new HashMap<>();

        for(int right=0;right<n;right++){
            char ch=s.charAt(right);
            map.put(ch,map.getOrDefault(ch,0)+1);
            length=right-left+1;
            maxfreq=Math.max(maxfreq,map.get(ch));
            while(length-maxfreq>k){
                char c=s.charAt(left);
                map.put(c,map.get(c)-1);
                if(map.get(c)==0){
                    map.remove(c);
                }
                left++;
                length=right-left+1;
                /*maxfreq=0;
                for(Character b: map.keySet()){
                    maxfreq=Math.max(maxfreq,map.get(b));
                }*/
            }
            length=right-left+1;
            res=Math.max(res,length);
        }
        return res;
    }
}