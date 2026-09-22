class Solution {
    public boolean isValid(String s) {
        int n=s.length();
        Stack<Character> a=new Stack<>();

        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            if(!a.isEmpty()){
                char ch=a.peek();
                if(ch=='('&&c==')'){
                    a.pop();
                }
                else if(ch=='{'&&c=='}'){
                    a.pop();
                }
                else if(ch=='['&&c==']'){
                    a.pop();
                }
                else{
                    a.push(c);
                }
            }
            else{
                a.push(c);
            }
        }
        if(a.isEmpty()){
            return true;
        }
        return false;
    }
}