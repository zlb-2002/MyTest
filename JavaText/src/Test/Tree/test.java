package Test.Tree;


import Test.Tree.TreeNode;

import java.util.*;

public class test {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        TreeNode root = createBiTree(new TreeNode());
        preOrder(root);

    }

    public static void preOrder (TreeNode root) {
        if (root != null) {
            System.out.println(root.val);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public static TreeNode createBiTree (TreeNode root) {

        int i;
        i = sc.nextInt();
        if (i == -1) {
            return null;
        } else {
            root.val = i;
            root.left = createBiTree(new TreeNode());
            root.right = createBiTree(new TreeNode());
            return root;
        }

    }

    public static TreeNode preOrderSearch(int val, TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        TreeNode tempNode = null;
        tempNode = preOrderSearch(val, root.left);
        if (tempNode == null) {
            tempNode = preOrderSearch(val, root.right);
        } else {
            return tempNode;
        }
        if (tempNode == null) {
            return null;
        } else {
            return null;
        }
    }

    public static void deleteNode (TreeNode root, int val) {
        if (root == null) {
            return ;
        }
        if (root.left.val == val) {
            root.left = null;
            return ;
        }

    }

}
