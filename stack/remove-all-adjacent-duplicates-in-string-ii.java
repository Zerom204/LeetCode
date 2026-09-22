class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<int[]> st=new Stack<>();
        int n=s.length();

        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(!st.isEmpty()&&st.peek()[0]==ch){
                st.peek()[1]++;
                if(st.peek()[1]==k){
                    st.pop();
                }
            }
            else{
                st.push(new int[]{ch,1});
            }
        }
        StringBuilder a=new StringBuilder();
        for(int[] pair:st){
            char ch=(char)pair[0];
            int count=pair[1];
            for(int i=0;i<count;i++){
                a.append(ch);
            }
        }
        return a.toString();
    }
}