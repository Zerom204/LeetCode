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
        int res=Integer.MIN_VALUE;
        int high=0;
        int low=0;
        int n=s.length();
        int f[]=new int[26];
        int max=Integer.MIN_VALUE;

        for(high=0;high<n;high++){
            f[s.charAt(high)-'A']++;
            int len=high-low+1;
            max=Math.max(max,f[s.charAt(high)-'A']);

            while(len-max>k){
                f[s.charAt(low)-'A']--;
                low++;
                //max=find(f);
                len=high-low+1;
            }
            len=high-low+1;
            res=Math.max(res,len);
        }
        return res;
        
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        int k=sc.nextInt();

        Solution obj=new Solution();
        System.out.println(obj.characterReplacement(s,k));
    }
}