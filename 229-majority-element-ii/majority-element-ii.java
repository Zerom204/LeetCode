class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int candidate1=0; int candidate2=0;
        int count1=0;   int count2=0;

        int n=nums.length;
        for(int i=0;i<n;i++){
            if(count1>0&&candidate1==nums[i]){
                count1++;
            }
            else if(count2>0&&candidate2==nums[i]){
                count2++;
            }
            else if(count1==0){
                candidate1=nums[i];
                count1=1;
            }
            else if(count2==0){
                candidate2=nums[i];
                count2=1;
            }
            else{
                count1--;
                count2--;
            }
        }
        
        List<Integer> res=new ArrayList<>();
        count1=0;
        count2=0;
        for(int i:nums){
            if(candidate1==i)   count1++;
            if(candidate2==i)   count2++;
        }
        if(count1>n/3){
            res.add(candidate1);
        }
        if(count2>n/3 && candidate1!=candidate2){
            res.add(candidate2);
        }
        return res;
    }
}