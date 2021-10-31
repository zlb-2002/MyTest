package leetcode;

class TreeNode {
    int val;
    TreeNode right;
    TreeNode left;
}

public class BalanceTree {

    //ƽ���������Ҫ��Ѱ����ȣ��Ƚ�������������ȣ�ʹ�õݹ�ȥѰ��������������ȣ�ֻҪ��������������һ��
    //�ȵ������ͷ���false�����򷵻�true
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
