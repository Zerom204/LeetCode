class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> map=new HashMap<>();
        HashMap<Character,Integer> map1=new HashMap<>();
        int n=s.length();
        int c=0,c1=0;
        if(s.length()==t.length()){
            for(int i=0;i<n;i++){
                map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
                map1.put(t.charAt(i),map1.getOrDefault(t.charAt(i),0)+1);
            }
            if(map.equals(map1))    return true;
            return false;
        }
        return false;
        
    }
}