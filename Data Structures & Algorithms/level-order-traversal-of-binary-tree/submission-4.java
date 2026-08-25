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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> res = new ArrayList<>();//[[1],]

        Queue<TreeNode> queue = new LinkedList<>();//
        queue.offer(root);//2,3

        while(!queue.isEmpty()) {
            int len = queue.size();//2
            List<Integer> curr = new ArrayList<>();//[]

            for(int i = 0; i < len; i++) {
                TreeNode top = queue.poll();//1
                curr.add(top.val);//[1]

                if(top.left != null) {
                    queue.offer(top.left);
                }

                if(top.right != null) {
                    queue.offer(top.right);
                }
            }

            res.add(curr);
        }

        return res; 
    }
}
