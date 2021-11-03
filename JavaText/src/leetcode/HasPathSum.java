package leetcode;

public class HasPathSum {


    /*路径总和
    路径总和 这道题需要知道他的路径总和，可以反向思考，只需要算出targetSum
    在最后叶子节点的值是否为0，为0就是返回为真，不为0就是返回为假。为空返回false。一条路走完之后就回溯。
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        targetSum -= root.val;
        if (root.right == null && root.left == null) {
            if (targetSum == 0) {
                return true;
            } else {
                return false;
            }
        }
        boolean b1 = false;
        boolean b2 = false;
        b1 = hasPathSum(root.right, targetSum);
        b2 = hasPathSum(root.left, targetSum);
        return b1 || b2;
    }

}
