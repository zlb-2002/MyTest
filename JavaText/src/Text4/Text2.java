package Text4;

import java.util.Scanner;
import java.util.Stack;

public class Text2 {

    public static void main(String[] args) {
        String s = null;
        Scanner sc = new Scanner(System.in);
        s = sc.nextLine();
        boolean b = reverse(s);
        if (b) {
            System.out.print("����");
        } else {
            System.out.print("���ǻ���");
        }
    }

    public static boolean reverse (String s) {
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < sb.length(); i++) {
            stack.push(sb.charAt(i));
        }
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) != stack.pop()) {
                return false;
            }
        }
        return true;
    }

}
