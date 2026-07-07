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
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        
        return dfs(root)[0] == 1;
        
    }
    
    // int array[0] => balanced or not array[1] => height of treee
    public int[] dfs(TreeNode root){
        if(root == null)
            return new int[]{1, 0};

        int[] leftHt = dfs(root.left);
        int[] rightHt = dfs(root.right);

        boolean balanced = (leftHt[0] == 1 && rightHt[0] == 1) && ((Math.abs(leftHt[1] - rightHt[1]) <= 1));
        int ht = 1 + Math.max(leftHt[1], rightHt[1]);

        return new int[]{balanced? 1:0, ht};
    }
}
