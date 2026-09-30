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
    int res=0;
    int count=0;
    public int fun(TreeNode root){
        if(root==null) return 0;

        int left=fun(root.left);
        int right=fun(root.right);
        int sum=left+right;
        res=Math.max(res,sum);

        return Math.max(left,right)+1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        fun(root);
        return res;
    }
}