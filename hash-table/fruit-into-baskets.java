class Solution {
    public int totalFruit(int[] fruits) {

        int low=0;
        int high=0;
        int res=0;
        int n=fruits.length;
        HashMap<Integer,Integer> map=new HashMap<>();

        for(high=0;high<n;high++){
            map.put(fruits[high],map.getOrDefault(fruits[high],0)+1);
            while(map.size()>2){
                map.put(fruits[low],map.get(fruits[low])-1);
                if(map.get(fruits[low])==0){
                    map.remove(fruits[low]);
                }
                low++;
            }
            
            int len=high-low+1;
            res=Math.max(res,len);
        }
        return res;
        
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        Solution obj=new Solution();
        int result=obj.totalFruit(arr);

        System.out.println(result);
    }
}