class Solution {
    public String removeDuplicates(String s) {
        int n=s.length();
        Stack<Character> stack=new Stack<>();
        String res="";
        if(s.equals("")){
            return res;
        }
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(!stack.isEmpty() && ch==stack.peek()){
                stack.pop();
            }
            else{
                stack.push(ch);
            }
        }
        StringBuilder ans = new StringBuilder();

        for (char ch : stack) {
            ans.append(ch);
        }

        return ans.toString();
    }
}