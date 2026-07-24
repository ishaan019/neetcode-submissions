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

    List<Integer> list = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);

        return list.get(k - 1);
        
    }

    void dfs(TreeNode root, int k) {
        if(root == null) {
            return;
        }

        dfs(root.left, k);
        list.add(root.val);
        k--;
        if(k == 0) {
            return;
        }
        dfs(root.right, k);
    } 
}
