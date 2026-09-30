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
    List<List<Integer>> ans=new ArrayList<>();
    int sum=0;
    public void fun(TreeNode root, int targetSum, ArrayList<Integer> path){
        if(root==null) return;
        sum+=root.val;
        path.add(root.val);
        if(root.left==null && root.right==null){
            if(sum==targetSum){
                ans.add(new ArrayList<>(path));
            }
        }
        fun(root.left,targetSum,path);
        fun(root.right,targetSum,path);
        sum-=root.val;
        path.remove(path.size()-1);
        return;
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        ArrayList<Integer> path=new ArrayList<>();
        fun(root,targetSum,path);
        return ans;
    }
}