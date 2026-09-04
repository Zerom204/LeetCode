class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //Sorting
        Arrays.sort(nums);
        int n=nums.length;

        //triplet sum->0
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<n-2;i++){
            int left=i+1;
            int right=n-1;
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            int sum=-1*nums[i];
            while(left<right){
                int s=nums[left]+nums[right];
                if(s==sum){
                    list.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    left++;
                    right--;
                    while(left<right && nums[left]==nums[left-1]){
                        left++;
                    }
                    while(right>left && nums[right]==nums[right+1]){
                        right--;
                    }
                }
                else if(s>sum){
                    right--;
                }
                else{
                    left++;
                }
            }
        }
        return list;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];

        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        Solution obj= new Solution();
        List<List<Integer>> l=new ArrayList<>();
        l=obj.threeSum(arr);
    }
}