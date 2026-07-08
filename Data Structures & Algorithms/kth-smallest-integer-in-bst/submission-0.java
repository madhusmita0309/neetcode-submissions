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
    List<Integer> result;
    public int kthSmallest(TreeNode root, int k) {
        // inorder traversal
        result = new ArrayList();
        dfs(root);
        return result.get(k-1);
    }

    public void dfs(TreeNode root){
        if(root == null)
            return;
        
        dfs(root.left);
        result.add(root.val);
        dfs(root.right);

    }
}
