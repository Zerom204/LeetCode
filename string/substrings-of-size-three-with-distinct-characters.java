class Solution {
    public int countGoodSubstrings(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        int l=s.length();
        int low=0;
        int res=0;
        if(l<3){
            return 0;
        }
        for(int i=low;i<3;i++){
            char ch=s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        if(map.size()==3){
            res++;
        }
        for(int high=3;high<l;high++){
            char ch=s.charAt(low);
            if(map.get(ch)==1){
                map.remove(ch);
            }
            else{
                map.put(ch,map.get(ch)-1);
            }
            low++;

            char ch2=s.charAt(high);
            map.put(ch2,map.getOrDefault(ch2,0)+1);
            if(map.size()==3){
                res++;
            }
        }
        return res;
    }
}