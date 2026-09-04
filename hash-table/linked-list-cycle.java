/*class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}*/
 
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args){
        /*Scanner sc=new Scanner(System.in);
        ListNode head=null;
        ListNode tail=null;
        System.out.println("Enter the values of the nodes and any character to stop:");
        while(sc.hasNextInt()){
            int a=sc.nextInt();
            ListNode newNode= new ListNode(a);
            if(head==null){
                head=tail=newNode;
            }
            else{
                tail.next=newNode;
                tail=newNode;
            }
        }
        sc.next();
        System.out.println("Enter index to connect the lastnode or -1 to not create a loop:");
        int n=sc.nextInt();
        if(n!=-1){
            ListNode temp=head;
            int c=0;
            while(temp!=null&&c<n-1){
                temp=temp.next;
                c++;
            }
            if(temp!=null){
                tail.next=temp;
            }
            else{
                System.out.println("Invalid position");
            }
        }
        Solution obj=new Solution();
        if(obj.hasCycle(head)){
            System.out.println("Cycle present");
        }
        else{
            System.out.println("No cycle present");
        }*/
    }
}