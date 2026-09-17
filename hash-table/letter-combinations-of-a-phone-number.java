class Solution {
    public void fun(String s, int n, int idx,String[] diary,StringBuilder choice,ArrayList<String> ans){
        if(idx==n){
            ans.add(choice.toString());
            return;
        }

        String letters=diary[s.charAt(idx)-'0'];
        for(int i=0;i<letters.length();i++){
            choice.append(letters.charAt(i));
            fun(s,n,idx+1,diary,choice,ans);
            choice.deleteCharAt(choice.length()-1);
        }


    }
    public List<String> letterCombinations(String digits) {
        ArrayList<String> res=new ArrayList<>();
        String diary[]={"",
        "",
        "abc",
        "def",
        "ghi",
        "jkl",
        "mno",
        "pqrs",
        "tuv",
        "wxyz"};
        fun(digits,digits.length(),0,diary,new StringBuilder(),res);
        return res;
    }
}