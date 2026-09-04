class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int low=0;
        int high=0;
        int n=nums.length;
        int result=Integer.MAX_VALUE;
        int sum=0;


        for(high=0;high<n;high++){
            sum=sum+nums[high];
            while(sum>=target){
                int len=high-low+1;
                result=Math.min(result,len);
                sum=sum-nums[low];
                low++;
            }
        }
        if(result==Integer.MAX_VALUE){
            return 0;
        }
        else{
            return result;
        }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int target=sc.nextInt();

        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        Solution obj=new Solution();
        int size=obj.minSubArrayLen(target,arr);
    }
}