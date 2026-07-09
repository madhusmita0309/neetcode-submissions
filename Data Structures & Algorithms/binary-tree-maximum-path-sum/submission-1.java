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
    int res;
    public int maxPathSum(TreeNode root) {
        res= Integer.MIN_VALUE;
        int m = dfs(root);
        return res;
    }

    public int dfs(TreeNode root){
        if(root == null)
            return 0;
        
        int left = Math.max(dfs(root.left), 0); // imp to ignore negative paths
        int right = Math.max(dfs(root.right), 0);
        int maxPath = root.val + left + right;

        res= Math.max(res, maxPath);

        return root.val + Math.max(left, right);
    }
}
