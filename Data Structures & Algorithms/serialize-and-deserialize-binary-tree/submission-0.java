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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        // preorder traversal
        List<String> values = new ArrayList();
        dfsSerializeHelper(root, values);
        return String.join(",", values);
    }

    public void dfsSerializeHelper(TreeNode root, List<String> values){
        if(root == null){
            values.add("N");
            return;
        }

        values.add(String.valueOf(root.val));
        dfsSerializeHelper(root.left, values);
        dfsSerializeHelper(root.right, values);

    }

    int index;
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] values = data.split(",");
        index = 0;
        TreeNode root = dfsDeserializeHelper(values);
        return root;
    }

    public TreeNode dfsDeserializeHelper(String[] values){
        if(values[index].equals("N")){
            index++;
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(values[index++]));
        root.left = dfsDeserializeHelper(values);
        root.right = dfsDeserializeHelper(values);

        return root;
    }
}
