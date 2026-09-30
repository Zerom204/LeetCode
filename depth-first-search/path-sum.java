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
    int sum=0;
    boolean ans=false;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null) return false;
        sum=sum+root.val;
        if(root.left==null && root.right==null){
            if(sum==targetSum){
                ans=true;
                return ans;
            }
        }
        ans= hasPathSum(root.left,targetSum) || hasPathSum(root.right,targetSum);
        sum-=root.val;
        return ans;
    }
}