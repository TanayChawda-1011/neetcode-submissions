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
        List<List<Integer>> l = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();

        if (root == null) {
            return l;
        }
        
        q.add(root);

        while(!q.isEmpty()) {
            ArrayList<Integer> level = new ArrayList<>();
            
            // queue's size keeps on changing throughout the for loop
            // , so we used it as an initialization!
            // if it were in the condition part, the code breaks!!
            for(int i = q.size(); i > 0; i--) {    
                TreeNode cur = q.poll();

                level.add(cur.val);
                if(cur.left != null)
                    q.add(cur.left);
                if(cur.right != null)
                    q.add(cur.right);
            }
            l.add(level);
        }

        return l;
    }
}
