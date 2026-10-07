class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res=new ArrayList<>();
        HashMap<String,ArrayList<String>> map=new HashMap<>();
        for(String str:strs){
            char[] ch=str.toCharArray();
            Arrays.sort(ch);

            String key=new String(ch);
            if(!map.containsKey(key)){
                map.put(key,new ArrayList<>());
                map.get(key).add(str);
            }
            else
            map.get(key).add(str);
        }
        for(String str:map.keySet()){
            res.add(new ArrayList<>(map.get(str)));
        }
        return res;
        
    }
}