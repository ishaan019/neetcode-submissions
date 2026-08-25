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
        List<String> list = new ArrayList<>();

        serializeDfs(root, list);

        System.out.println(list);//1,2,N,N,3,4,N,N,5,N,N

        return String.join(",", list);
    }

    void serializeDfs(TreeNode root, List<String> list) {
        if(root == null) {
            list.add("N");
            return;
        }

        //preorder
        list.add(root.val + "");
        serializeDfs(root.left, list);
        serializeDfs(root.right, list);
    }

    // Decodes your encoded data to tree.
    
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");

        return dfsDeserialize(arr);        
    }

    int idx = 0;
    TreeNode dfsDeserialize(String[] arr) {
        if(arr[idx].equals("N")) {
            idx++;
            return null;
        }

        TreeNode node = new TreeNode(Integer.valueOf(arr[idx]));
        idx++;
        node.left = dfsDeserialize(arr);
        node.right = dfsDeserialize(arr);

        return node;
    }
}
