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
    public int rob(TreeNode root) {
        Map<TreeNode, Integer> memo = new HashMap<>();
        
        return dfs(root, memo);
    }

    public int dfs(TreeNode root, Map<TreeNode, Integer> memo) {
        if(root == null)    return 0;
        if(memo.containsKey(root))  return memo.get(root);

        int includeRoot = root.val;
        int skip = dfs(root.left, memo) + dfs(root.right, memo);

        if(root.left != null) {
            includeRoot += dfs(root.left.left, memo);
            includeRoot += dfs(root.left.right, memo);
        }
        if(root.right != null) {
            includeRoot += dfs(root.right.left, memo);
            includeRoot += dfs(root.right.right, memo);
        }

        int res = Math.max(includeRoot, skip);
        memo.put(root, res);
        return res;
    }
}





