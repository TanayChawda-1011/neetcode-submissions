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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();

        if(root == null)
            return res;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        // res.add(root.val);

        while(!q.isEmpty()) {
            int rightMostValue = 0;
            
            for(int i = q.size(); i > 0; i--) {
                TreeNode cur = q.poll();
                rightMostValue = cur.val;

                if(cur.left != null)
                    q.add(cur.left);
                if(cur.right != null)
                    q.add(cur.right);
            }
            res.add(rightMostValue);
        }
        return res;
    }
}
