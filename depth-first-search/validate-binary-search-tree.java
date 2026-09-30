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
    TreeNode prev=null;
    boolean ans=true;
    public void inorder(TreeNode root){
        if(root==null) return;
        inorder(root.left);
        if(prev==null){
            prev=root;
        }
        else{
            if(root.val<=prev.val){
                ans=false;
            }
            prev=root;
        }
        inorder(root.right);
        return;
    }
    public boolean isValidBST(TreeNode root) {
        inorder(root);
        return ans;
    }
}