class Solution {
    public int numberOfSubstrings(String s) {
        int left=0;
        int n=s.length();
        int res=0;

        HashMap<Character,Integer> map=new HashMap<>();
        map.put('a',-1);
        map.put('b',-1);
        map.put('c',-1);

        for(int right=0;right<n;right++){
            char ch=s.charAt(right);
            map.put(ch,right);
            if(map.get('a')!=-1&&map.get('b')!=-1&&map.get('c')!=-1)
            res=res+1+Math.min(map.get('a'),Math.min(map.get('b'),map.get('c')));
        }
        return res;
    }
}