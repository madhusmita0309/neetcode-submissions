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
    
    
    public int goodNodes(TreeNode root) {
        int result = 0;
        result = dfs(root, Integer.MIN_VALUE);

        return result;
        
    }

    public int  dfs(TreeNode root, int maxValue){
        if(root == null)
            return 0;
        
        int result = root.val >= maxValue ? 1: 0;
        maxValue = Math.max(maxValue, root.val);
        result = result + dfs(root.left, maxValue);
        result = result + dfs(root.right, maxValue);
        
        return result;
    }
}
