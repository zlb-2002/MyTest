package leetcode;

class TreeNode {
    int val;
    TreeNode right;
    TreeNode left;
}

public class BalanceTree {

    //平衡二叉树主要是寻找深度，比较两个子树的深度，使用递归去寻找两个子树的深度，只要存在两个相差大于一深
    //度的子树就返回false，否则返回true
    class Solution {
        public boolean isBalanced(TreeNode root) {
            if (root == null) {
                return true;
            } else {
                return Math.abs(height(root.left) - height(root.right)) <= 1
                        && isBalanced(root.right) && isBalanced(root.left);
            }
        }

        public int height (TreeNode root) {
            int left,right;
            if (root == null) {
                return 0;
            } else {
                return Math.max(height(root.left)+1, height(root.right)+1);
            }

        }
    }

}
