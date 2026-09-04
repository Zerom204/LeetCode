import java.util.Scanner;
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n=nums.length;
        int diff= Integer.MAX_VALUE;
        int result=0;

        for(int i=0;i<n-2;i++){
            int left=i+1;
            int right=n-1;
            while(left<right){
                int sum=nums[i]+nums[left]+nums[right];
                int d=Math.abs(sum-target);

                if(diff>d){
                    diff=d;
                    result=sum;
                }

                if(sum==target){
                    left++;
                    right--;
                }
                else if(sum<target){
                    left++;
                }
                else{
                    right--;
                }
            }
        }
        return result;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }

        int target=sc.nextInt();

        Solution obj=new Solution();
        int ans=obj.threeSumClosest(arr,target);
    }
}