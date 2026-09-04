import java.util.ArrayList;
class Solution {
    public int[] sortedSquares(int[] nums) {
        ArrayList<Integer> list1=new ArrayList<Integer>();
        ArrayList<Integer> list2=new ArrayList<Integer>();
        int n=nums.length;

        for(int i=0;i<n;i++){
            if(nums[i]<0){
                list1.add(nums[i]);
            }
            else{
                list2.add(nums[i]);
            }
        }

        for(int i=0;i<list1.size();i++){
            int a=list1.get(i);
            a=a*a;
            list1.set(i,a);
        }

        for(int i=0;i<list2.size();i++){
            int a=list2.get(i);
            a=a*a;
            list2.set(i,a);
        }

        int i=list1.size()-1;
        int j=0;
        int pp=0;

        while(i>=0 && j<list2.size()){
            if(list1.get(i)<list2.get(j)){
                nums[pp]=list1.get(i);
                i--;
                pp++;
            }
            else if(list1.get(i)>list2.get(j)){
                nums[pp]=list2.get(j);
                j++;
                pp++;
            }
            else{
                nums[pp]=list1.get(i);
                pp++;
                nums[pp]=list2.get(j);
                i--;
                pp++;
                j++;
            }
        }
       
        while(i>=0){
            nums[pp]=list1.get(i);
            i--;
            pp++;
        }
        while(j<list2.size()){
            nums[pp]=list2.get(j);
            j++;
            pp++;
        }

        return nums;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        } 
        Solution obj=new Solution();
        int arr1[]=obj.sortedSquares(arr);
    }
}