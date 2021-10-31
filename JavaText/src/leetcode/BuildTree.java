package leetcode;


import java.util.*;

public class BuildTree {


    /*
    从前序与中序遍历构造二叉树
        因为先序是先遍历根节点，再是左子树，最后是右子树，中序遍历是先遍历左子树，再是根节点，最后是右节点，我们要找到根节点在中序中的位置，
        左边是左子树，右边是右子树，先序的第一个是根节点，我们可以根据先序的根节点找到中序根节点，再递归创建左子树和右子树。
        （我知道这是如何实现的，但是代码不是很会写，代码是根据题解写的）
     */
    Map<Integer, Integer> map;
    public void buildMap (int[] inorder) {
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
    }
    public TreeNode build (int[] preorder, int[] inorder, int preorder_start, int preorder_end, int inorder_start, int inorder_end) {
        TreeNode root = new TreeNode();
        int inorder_root = map.get(preorder[preorder_start]);

        int size = inorder_root - inorder_start;
        root.val = preorder[preorder_start];
        root.left = build(preorder, inorder, preorder_start+1, preorder_start + size,
                inorder_start, inorder_root - 1);
        root.right = build(preorder, inorder, preorder_start+size+1, preorder_end, inorder_root + 1, inorder_end);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        buildMap(inorder);
        return build(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
    }
}
