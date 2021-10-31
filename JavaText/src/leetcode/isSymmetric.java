package leetcode;

public class isSymmetric {


    /*
    对称二叉树:
    本题需要找到二叉树的子节点的左子树与子节点的右子树递归比较，若子树相等就是对称二叉树
     */
    class Solution {
        public boolean isSymmetric(TreeNode root) {
            if (root == null) {
                return true;
            }
            return helper(root.left, root.right);
        }

        public boolean helper (TreeNode root1, TreeNode root2) {
            if (root1 == null && root2 == null) {
                return true;
            }
            if (root1 == null || root2 == null) {
                return false;
            }
            if (root1.val == root2.val) {
                return helper(root1.left, root2.right) && helper(root1.right, root2.left);
            } else {
                return false;
            }
        }
    }

}
