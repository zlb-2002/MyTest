package Test.Tree;


import Test.Tree.TreeNode;

import java.util.*;

public class test {

    private static Scanner sc = new Scanner(System.in);
    private static String string;
    static int i = 0;

    public static void main(String[] args) {
        string = sc.nextLine();
        TreeNode root = createBiTree(new TreeNode());
        List<List<Character>> lists = levelOrder(root);
        for (List<Character> list : lists) {
            for (Character character : list) {
                System.out.print(character);
            }
        }
    }

    public static void preOrder (TreeNode root) {
        if (root != null) {
            System.out.print(root.val);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    private static final List<List<Character>> lists = new ArrayList<>();

    public static void level (TreeNode root, int l) {
        if (lists.size() == l) {
            lists.add(new ArrayList<Character>());
        }
        lists.get(l).add(root.val);
        if (root.left != null) {
            level(root.left, l + 1);
        }
        if (root.right != null) {
            level(root.right, l + 1);
        }
    }

    public static List<List<Character>> levelOrder(TreeNode root) {
        if (root != null) {
            level(root, 0);
        }
        return lists;

    }

    public static TreeNode createBiTree (TreeNode root) {
        char c;
        c = string.charAt(i);
        i++;
        if (c == '#') {
            return null;
        } else {
            root.val = c;
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
        return null;
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
