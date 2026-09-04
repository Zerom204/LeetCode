class Solution {
    public boolean check(HashMap<Character, Integer> mapt, HashMap<Character, Integer> maps){
        for(char key:mapt.keySet()){
            if(!maps.containsKey(key)||maps.get(key)<mapt.get(key)){
                return false;
            }
        }
        return true;
    }
    
    public String minWindow(String s, String t) {
        int low=0,high=0;
        int res=Integer.MAX_VALUE;
        HashMap<Character,Integer> mapt=new HashMap<>();
        int n1=t.length();
        int start=0;
        for(int i=0;i<n1;i++){
            char ch=t.charAt(i);
            mapt.put(ch,mapt.getOrDefault(ch,0)+1);
        }

        HashMap<Character,Integer> maps=new HashMap<>();
        int n=s.length();
        for(high=0;high<n;high++){
            char c=s.charAt(high);
            maps.put(c,maps.getOrDefault(c,0)+1);
            while(check(mapt,maps)){
                char ch=s.charAt(low);
                int len=high-low+1;
                if(res>len){
                    res=len;
                    start=low;
                }
                maps.put(ch,maps.get(ch)-1);
                if(maps.get(ch)==0){
                    maps.remove(ch);
                }
                low++;
            }
        }
        if(res== Integer.MAX_VALUE){
            return "";
        }
        return(s.substring(start,(start+res)));
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        String t=sc.nextLine();

        Solution obj=new Solution();
        System.out.println(obj.minWindow(s,t));
    }

}