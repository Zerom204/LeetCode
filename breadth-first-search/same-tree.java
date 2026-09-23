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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null)
        return true;

        if(p==null || q==null)
        return false;

        if(p.val!=q.val)
        return false;

        boolean a1=isSameTree(p.left,q.left);
        boolean a2=isSameTree(p.right,q.right);

        if(a1&&a2)
        return true;

        return false;
    }
}