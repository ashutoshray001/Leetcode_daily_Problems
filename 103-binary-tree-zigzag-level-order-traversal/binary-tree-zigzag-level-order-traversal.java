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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        boolean leftToRight = true;
        if (root == null)
            return ans;
        q.add(root);
        while (!q.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode front = q.remove();
                if (leftToRight) {
                    level.add(front.val);
                } else {
                    level.addFirst(front.val);
                }
                if (front.left != null)
                    q.add(front.left);
                if (front.right != null)
                    q.add(front.right);
            }
            ans.add(level);
            leftToRight = !leftToRight;
        }
        return ans;
        

    }
}