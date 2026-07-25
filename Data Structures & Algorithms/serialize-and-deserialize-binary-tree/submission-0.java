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

    int idx = 0;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> res = new ArrayList<>();
        dfsSerialize(root, res);

        return String.join(",", res);
    }

    void dfsSerialize(TreeNode root, List<String> res) {
        if(root == null) {
            res.add("N");
            return;
        }

        res.add(String.valueOf(root.val));
        dfsSerialize(root.left, res);
        dfsSerialize(root.right, res);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        System.out.println(data);
        String vals[] = data.split(",");

        
        return dfsDeserialize(vals);
    }

    TreeNode dfsDeserialize(String[] vals) { //1,2,N,N,3,4,N,N,5,N,N
        if(vals[idx].equals("N")) {
            idx++;
            return null;
        } 

        TreeNode node = new TreeNode(Integer.parseInt(vals[idx]));
        idx++;
        node.left = dfsDeserialize(vals);
        node.right = dfsDeserialize(vals);
        return node;
    }
}
