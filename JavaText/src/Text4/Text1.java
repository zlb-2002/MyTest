package Text4;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Text1 {

    public static void main(String[] args) {
        String line = getString();
        List<String> list = change1(line);
        List<String> list2 = change2(list);
        System.out.println(countResult(list2));
    }

    private static List<String> change2(List<String> list) {
        List<String> list1 = new ArrayList<>();
        Stack<String> stack2 = new Stack<>();
        for (String string : list) {
            if ("+".equals(string) || "-".equals(string)) {
                if (!stack2.isEmpty() && ("*".equals(stack2.peek()) || "/".equals(stack2.peek()))) {
                    while (!stack2.isEmpty()) {
                        list1.add(stack2.pop());
                    }
                }
                stack2.push(string);
            } else if ("*".equals(string) || "/".equals(string)) {
                stack2.push(string);
            } else {
                list1.add(string);
            }
        }
        while (!stack2.isEmpty()) {
            list1.add(stack2.pop());
        }
        return list1;
    }

    public static String getString () {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public static List<String> change1(String s) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < s.length();) {
            if (s.charAt(i) == '+') {
                list.add("+");
                i++;
            } else if (s.charAt(i) == '-') {
                list.add("-");
                i++;
            } else if (s.charAt(i) == '*') {
                list.add("*");
                i++;
            } else if (s.charAt(i) == '/') {
                list.add("/");
                i++;
            } else if (s.charAt(i) == '#') {
                break;
            } else {
                StringBuilder str = new StringBuilder();
                while (i < s.length() && s.charAt(i) <= '9' && s.charAt(i) >= '0') {
                    str.append(s.charAt(i));
                    i++;
                }
                list.add(str.toString());
            }
        }
        return list;
    }

    public static String countResult(List<String> list) {
        Stack<Integer> myStack = new Stack<>();
        Integer string_1, string_2;
        for (String string : list) {
            if (isNumber(string)) {
                myStack.push(Integer.parseInt(string));
            } else {
                string_1 = myStack.pop();
                string_2 = myStack.pop();
                switch (string) {
                    case "+" -> myStack.push(string_1 + string_2);
                    case "-" -> myStack.push(string_2 - string_1);
                    case "*" -> myStack.push(string_1 * string_2);
                    case "/" -> myStack.push(string_2 / string_1);
                }
            }
        }

        return myStack.peek().toString();
    }

    public static boolean isNumber(String string) {
        return !(string.equals("+") || string.equals("-") || string.equals("*") || string.equals("/")
                || string.equals("(") || string.equals(")"));
    }



}
