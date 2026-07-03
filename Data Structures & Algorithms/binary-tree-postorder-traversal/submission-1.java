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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null)    return res;
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        TreeNode prev = null;

        while(cur != null || !stack.isEmpty()) {
            // 1. Go all the way to the left, cuz that's what we do in recursion as well
            while(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            // 2. Now peek to see if we've completed its right subtree or not. And can We visit it?
            TreeNode node = stack.peek();

            if(node.right == null || node.right == prev) {
                prev = stack.pop();
                res.add(node.val);
            } else {
                cur = node.right;
            }
        }

        return res;
    }
}