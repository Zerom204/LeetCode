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
    TreeNode w11=null;
    TreeNode w12=null;
    TreeNode w21=null;
    TreeNode w22=null;
    TreeNode prev=null;
    int w=0;
    public void fun(TreeNode root){
        if(root==null) return;
        fun(root.left);
        if(prev==null){
            prev=root;
        }
        else{
            if(root.val<prev.val){
                if(w==0){
                    w11=prev;
                    w12=root;
                }
                else{
                    w21=prev;
                    w22=root;
                }
                w++;
            }
            prev=root;
        }
        fun(root.right);
    }
    public void recoverTree(TreeNode root) {
        fun(root);
        if(w==1){
            int temp=w11.val;
            w11.val=w12.val;
            w12.val=temp;
        }
        if(w==2){
            int temp=w11.val;
            w11.val=w22.val;
            w22.val=temp;
        }
    }
}