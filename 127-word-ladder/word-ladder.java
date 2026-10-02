class Solution {
    class pair{
        String str;
        int val;
        pair(String str,int val){
            this.str=str;
            this.val=val;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int n=wordList.size();
        HashSet<String> map=new HashSet<>();
        for(int i=0;i<n;i++){
            map.add(wordList.get(i));
        }
        if(!map.contains(beginWord))    map.add(beginWord);
        if(!map.contains(endWord))  return 0;

        Queue<pair> q=new LinkedList<>();

        q.offer(new pair(beginWord,1));

        while(!q.isEmpty()){
            pair p=q.poll();
            int val=p.val;
            StringBuilder s=new StringBuilder(p.str);

            if(s.toString().equals(endWord))  return val;

            for(int i=0;i<s.length();i++){
                char ch=s.charAt(i);
                for(char c='a';c<='z';c++){
                    if(c==ch)    continue;
                    s.setCharAt(i,c);
                    if(map.contains(s.toString())){
                        q.offer(new pair(s.toString(),val+1));
                        map.remove(s.toString());
                    }
                }
                s.setCharAt(i,ch);
            }
        }
        return 0;
    }
}