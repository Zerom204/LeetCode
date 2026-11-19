class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int left=0;
        int n=cardPoints.length;
        int wsize=n-k;
        int right=wsize-1;
        int total=0;
        int sum=0;
        for(int i=0;i<n;i++){
            if(i<wsize)    sum+=cardPoints[i];
            total+=cardPoints[i];
        }
        int lowsum=sum;
        while(right<n-1){
            sum=sum-cardPoints[left];
            left++;
            right++;
            sum=sum+cardPoints[right];
            lowsum=Math.min(sum,lowsum);
        }
        total-=lowsum;
        return total;
    }
}