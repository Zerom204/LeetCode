class Solution {
    public void fun(int open,int close,int n,StringBuilder temp, List<String> res){
        if(open==n&&close==n){
            res.add(temp.toString());
            return;
        }

        if(open<n){
            temp.append('(');
            fun(open+1,close,n,temp,res);
            temp.deleteCharAt(temp.length()-1);
        }

        if(close<open){
            temp.append(')');
            fun(open,close+1,n,temp,res);
            temp.deleteCharAt(temp.length()-1);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String>res =new ArrayList<>();
        StringBuilder temp=new StringBuilder();
        fun(0,0,n,temp,res);
        return res;
    }
}