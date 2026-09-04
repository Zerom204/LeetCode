class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int l=s1.length();
        int n=s2.length();
        if(l>n){
            return false;
        }
        int high=0;
        int low=0;
        int f1[]=new int[26];
        int f2[]=new int[26];
        for(int i=0;i<l;i++){
            f1[s1.charAt(i)-'a']++;
            f2[s2.charAt(i)-'a']++;

        }

        for(high=l;high<n; high++){
            
            if(Arrays.equals(f1,f2)){
                return true;
            }

            f2[s2.charAt(high-l)-'a']--;
            f2[s2.charAt(high)-'a']++;
        }
        return Arrays.equals(f1,f2);
    }
}