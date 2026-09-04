import java.util.Scanner;
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int j=numbers.length-1;
        int i=0;

        int arr[]=new int[j+1];
        int count =0;

        while(i<j){
            int sum=numbers[i]+numbers[j];
            if(sum==target){
                arr[count]=i+1;
                count++;

                arr[count]=j+1;
                count++;

                i++;
                j--;
            }
            else if(sum>target){
                j--;
            }
            else{
                i++;
            }
        }
        int fin[]=new int[count];
        for(int k=0;k<count;k++){
            fin[k]=arr[k];
        }
        return fin;
    }
    public static void main(String []args){
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter the number of array cells: ");
        int n=sc.nextInt();
        int num[]= new int[n];
        System.out.println("Enter the numbers");
        for(int i=0;i<n;i++){
            num[i]=sc.nextInt();
        }

        System.out.println("Enter the target variable: ");
        int target=sc.nextInt();

        Solution obj=new Solution();
        int s[]=obj.twoSum(num,target);
    }
}