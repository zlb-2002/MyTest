package leetcode;


import java.util.*;

public class BuildTree {


    /*
    ��ǰ��������������������
        ��Ϊ�������ȱ������ڵ㣬�����������������������������������ȱ��������������Ǹ��ڵ㣬������ҽڵ㣬����Ҫ�ҵ����ڵ��������е�λ�ã�
        ��������������ұ���������������ĵ�һ���Ǹ��ڵ㣬���ǿ��Ը�������ĸ��ڵ��ҵ�������ڵ㣬�ٵݹ鴴������������������
        ����֪���������ʵ�ֵģ����Ǵ��벻�Ǻܻ�д�������Ǹ������д�ģ�
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
