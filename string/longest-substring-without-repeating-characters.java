class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        int high=0;
        int low=0;
        int res=0;
        HashMap<Character, Integer> map=new HashMap<>();

        for(high=0;high<n;high++){
            char ch=s.charAt(high);
            map.put(ch,map.getOrDefault(ch,0)+1);
            int k=high-low+1;

            while(map.size()<k){
                char c=s.charAt(low);
                map.put(c,map.get(c)-1);
                if(map.get(c)==0){
                    map.remove(c);
                }
                low++;
                k=high-low+1;
            }

            int len=high-low+1;
            res=Math.max(res,len);
        }

        return res;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();

        Solution obj=new Solution();
        int result=obj.lengthOfLongestSubstring(s);
        System.out.println(result);
    }
}