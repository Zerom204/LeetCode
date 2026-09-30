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
    public int fun(TreeNode root){
        if(root==null) return 0;
        if(root.left==null) return 1+fun(root.right);
        if(root.right==null) return 1+fun(root.left);
        return 1+Math.max(fun(root.left),fun(root.right));
    }
    public int maxDepth(TreeNode root) {
        return fun(root);
    }
}