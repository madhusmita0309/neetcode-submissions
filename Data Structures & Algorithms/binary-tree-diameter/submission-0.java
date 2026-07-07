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
    int result;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null)
            return 0;
        

        int d = helperDepthFunction(root);
        return result;
    }

    public int helperDepthFunction(TreeNode root){
        if(root == null)
            return 0;
        
        int leftHeight = helperDepthFunction(root.left);
        int rightHeight = helperDepthFunction(root.right);

        int maxLength = leftHeight + rightHeight;
        result = Math.max(result, maxLength);

        return 1 + Math.max(leftHeight, rightHeight);

    }
}
