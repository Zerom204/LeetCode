class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> res=new ArrayList<>();
        ArrayList<int[]> res1=new ArrayList<>();
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int start1=0;
        int end1=0;
        boolean insert=false;
        for(int i=0;i<intervals.length;i++){
            start1=intervals[i][0];
            if(insert==false&&start1>=newInterval[0]){
                res1.add(new int[]{newInterval[0],newInterval[1]});
                insert=true;
            }
            res1.add(new int[]{intervals[i][0],intervals[i][1]});
        }
        if(insert==false){
            res1.add(new int[]{newInterval[0],newInterval[1]});
        }
        start1=res1.get(0)[0];
        end1=res1.get(0)[1];

        for(int i=1;i<res1.size();i++){
            int start2=res1.get(i)[0];
            int end2=res1.get(i)[1];
            if(end1>=start2){
                end1=Math.max(end1,end2);
            }
            else{
                res.add(new int[]{start1,end1});
                start1=start2;
                end1=end2;
            }
        }
        res.add(new int[]{start1,end1});
        return res.toArray(new int[res.size()][]);
    }
}