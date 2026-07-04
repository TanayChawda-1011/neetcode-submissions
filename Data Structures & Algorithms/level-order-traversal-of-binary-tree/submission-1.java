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
        List<List<Integer>> res = new ArrayList<>();

        if(root == null) return res;

        Deque<TreeNode> q = new ArrayDeque<>();

        if(root != null)
            q.offer(root);

        while(!q.isEmpty()) {
            ArrayList<Integer> layer = new ArrayList<>();

            // Queue's size keeps on changing throughout the for loop, 
            // so we only used it for the initialization paty
            // And not in the condition section of the loop's template
            for(int i = q.size(); i > 0; i--) {
                TreeNode cur = q.poll();

                layer.add(cur.val);
                if(cur.left != null)
                    q.offer(cur.left);
                if(cur.right != null)   
                    q.offer(cur.right);
            }
            res.add(layer);
        }

        return res;
    }
}
