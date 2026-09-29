/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    Stack<TreeNode> asc=new Stack<>();
    Stack<TreeNode> desc=new Stack<>();
    public TreeNode getbig(){
        if(desc.isEmpty()) return null;

        TreeNode big=desc.pop();
        TreeNode leftchild=big.left;
        while(leftchild!=null){
            desc.push(leftchild);
            leftchild=leftchild.right;
        }
        return big;
    }
    public TreeNode getsmall(){
        if(asc.isEmpty()) return null;

        TreeNode small=asc.pop();
        TreeNode rightchild=small.right;
        while(rightchild!=null){
            asc.push(rightchild);
            rightchild=rightchild.left;
        }
        return small;
    }
    public boolean findTarget(TreeNode root, int k) {
        if(root==null) return false;

        TreeNode t=root;
        while(t!=null){
            asc.push(t);
            t=t.left;
        }
        t=root;
        while(t!=null){
            desc.push(t);
            t=t.right;
        }
        TreeNode i=getsmall();
        TreeNode j=getbig();
        while(j!=null && i!=null && i!=j && i.val<=j.val){
            int sum=i.val+j.val;
            if(sum==k) return true;
            if(sum<k) i=getsmall();
            else j=getbig();
        }
        return false;
    }
}