class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int i=0;
        int j=0;
        ArrayList<int[]> res=new ArrayList<>();
        while(i < firstList.length && j < secondList.length){
            int start1=firstList[i][0];
            int end1=firstList[i][1];

            int start2=secondList[j][0];
            int end2=secondList[j][1];

                int s=Math.max(start1,start2);
                int e=Math.min(end1,end2);
                if(s<=e)
                res.add(new int[]{s,e});

            if(end1<=end2){
                i++;
            }
            else{
                j++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}