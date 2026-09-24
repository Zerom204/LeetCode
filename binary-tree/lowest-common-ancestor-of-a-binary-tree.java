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
    TreeNode ans=null;
    public int lca(TreeNode root,TreeNode p, TreeNode q){
        if(root==null)
        return 0;

        int l=lca(root.left,p,q);
        int r=lca(root.right,p,q);

        int self=0;
        if(root.val==p.val||root.val==q.val){
            self=1;
        }

        int total=l+r+self;

        if(total==2&&ans==null){
            ans=root;
        }
        return total;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        lca(root,p,q);
        return ans;
    }
}