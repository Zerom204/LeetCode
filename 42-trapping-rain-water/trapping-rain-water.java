class Solution {
    public int trap(int[] height) {
        int n=height.length;
        if(n==0)    return 0;
        //prefix max
        ArrayList<Integer> prefix=new ArrayList<>();
        prefix.add(height[0]);
        for(int i=1;i<n;i++){
            prefix.add(Math.max(height[i],prefix.get(i-1)));
        }
        //suffix max
        ArrayList<Integer> suffix=new ArrayList<>();
        suffix.add(height[n-1]);
        for(int i=n-2;i>=0;i--){
            suffix.add(Math.max(height[i],suffix.get(suffix.size()-1)));
        }
        Collections.reverse(suffix);
        //calculations
        int watercapacity=0;
        for(int i=0;i<n;i++){
            if(height[i]<suffix.get(i) && height[i]<prefix.get(i))
            watercapacity+=Math.min(suffix.get(i),prefix.get(i))-height[i];
        }
        return watercapacity;
    }
}