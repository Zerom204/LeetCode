class Solution {
    public int longestOnes(int[] nums, int k) {
        int high=0;
        int low=0;
        int res=Integer.MIN_VALUE;
        int count=0;
        int n=nums.length;

        for(high=0;high<n;high++){
            if(nums[high]==0){
                count++;
            }

            while(count>k){
                if(nums[low]==0){
                    count--;
                }
                low++;
            }
            int len=high-low+1;
            res=Math.max(len,res);
        }
        return res;
        

    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }

        Solution obj=new Solution();
        System.out.println(obj.longestOnes(arr,k));
    }
}