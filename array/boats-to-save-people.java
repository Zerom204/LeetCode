class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int left=0;
        int right=people.length-1;
        int res=0;

        Arrays.sort(people);

        while(left<=right){
            int weight=people[left]+people[right];
            if(weight<=limit){
                left++;
            }
            right--;
            res++;
        }
        return res;
    }
}