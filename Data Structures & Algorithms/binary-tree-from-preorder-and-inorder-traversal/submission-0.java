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
    int preorderIndex = 0;
    HashMap<Integer, Integer> inorderIndex;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0)
            return null;
           
        inorderIndex = new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            inorderIndex.put(inorder[i], i);
        }

        TreeNode root = dfs(preorder, 0, inorder.length-1);

        return root;
    }

    public TreeNode dfs(int[] preorder, int left, int right){
        if(left > right)
            return null;

        TreeNode node = new TreeNode(preorder[preorderIndex]);
        int mid = inorderIndex.get(preorder[preorderIndex]);
        preorderIndex++;
        node.left = dfs(preorder, left, mid-1);
        node.right = dfs(preorder, mid+1, right);

        return node;
    }
}
