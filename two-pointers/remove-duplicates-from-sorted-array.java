import java.util.Scanner;
class Solution {
    public int removeDuplicates(int[] nums) {
        int n=nums.length;
        int p1=0;
        int p2=1;
        int unique=1;

        while(p2<n){
            if(nums[p1]==nums[p2]){
                p2++;
                continue;
            }

            unique++;
            p1++;
            nums[p1]=nums[p2];
            p2++;
        }

        return unique;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter the number of elements in the array: ");
        int n=sc.nextInt();

        System.out.println("Input the elements of the array: ");
        int arr[]=new int[n];

        Solution obj= new Solution();
        int ans=obj.removeDuplicates(arr);

        System.out.println("The number of unique elemets are "+ ans);

        System.out.println("Modified array: ");
        for(int i=0;i<ans;i++){
            System.out.print(arr[i]+ " ");
        }
    }
}