class Solution {
    public boolean check(HashMap<Character,Integer> map1,HashMap<Character,Integer> map){
        for(char key:map1.keySet()){
            if(!map.containsKey(key)||map.get(key)<map1.get(key))   return false;
        }
        return true;
    }
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> map1=new HashMap<>();
        int n1=t.length();
        int start=0;
        int res=Integer.MAX_VALUE;
        
        for(int i=0;i<n1;i++){
            char ch=t.charAt(i);
            map1.put(ch,map1.getOrDefault(ch,0)+1);
        }

        HashMap<Character,Integer> map=new HashMap<>();
        int low=0;
        int high=0;

        for(high=0;high<s.length();high++){
            char ch=s.charAt(high);
            if(map1.containsKey(ch)){
                map.put(ch,map.getOrDefault(ch,0)+1);
            }

            while(check(map1,map)){
                char c=s.charAt(low);  
                int l=high-low+1;
                if(l<res){
                    res=l;
                    start=low;
                }
                if(map1.containsKey(c)){ 
                    map.put(c,map.get(c)-1);
                    if(map.get(c)==0)   map.remove(c);
                }
                low++;
            }
        }

        if(res==Integer.MAX_VALUE)  return "";
        
        String str=s.substring(start,(start+res));  
        return str;  
    }
}