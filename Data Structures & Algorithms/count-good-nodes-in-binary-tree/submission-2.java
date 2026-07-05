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
    // int max = Integer.MIN_VALUE;
    int goodNodes = 0;

    public int goodNodes(TreeNode root) {
        int max = Integer.MIN_VALUE;
        dfs(root, max);
        return goodNodes;
    }

    public void dfs(TreeNode root, int max) {
        if(root == null)    return;

        if(root.val >= max) {
            goodNodes++;
            max = root.val;
        }

        dfs(root.left, max);
        // max = root.val;
        dfs(root.right, max);
    }
}
