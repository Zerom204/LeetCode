/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lca(TreeNode root, TreeNode p, TreeNode q){
        if(root==null){
            return null;
        }
        if(root.val==p.val||root.val==q.val){
            return root;
        }
        if(root.val<p.val){
            return lca(root.right,p,q);
        }
        else if(root.val>q.val){
            return lca(root.left,p,q);
        }
        else{
            return root;
        }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ans=null;
        if(p.val>q.val){
            ans=lca(root,q,p);
        }
        else{
            ans=lca(root,p,q);
        }
        return ans;
    }
}