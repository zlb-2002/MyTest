package leetcode;

public class SameTree {

    /*相同的树
        相同的树就是树的遍历，就是将两个树同时遍历，如果它们可以一直遍历下去，
        就说明它们是相同的树，如果他们不能遍历下去，就结束递归，说明它们不是相同的树
     */

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q != null) {
            return false;
        } else if (p != null && q == null) {
            return false;
        } else if (p == null && q == null) {
            return true;
        }
        boolean b1 = false;
        boolean b2 = false;
        if (p.val == q.val) {
            b1 = isSameTree(p.right, q.right);
            b2 = isSameTree(p.left, q.left);
        }
        return b1 && b2;
    }

}
