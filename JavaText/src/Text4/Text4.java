package Text4;

import java.util.*;

public class Text4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        List<String> list1 = change1(s);
        List<String> list2 = change2(list1);
        print(list2);
    }

    public static void print (List<String> list) {
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s);
        }
        System.out.print(sb.toString());
    }

    public static List<String> change2(List<String> list1) {
        ArrayList<String> list = new ArrayList<>();
        Stack<String> myStack = new Stack<>();

        String temp;
        for (int i = 0;i < list1.size();i++) {
            if (isChar(list1.get(i))) {
                list.add(list1.get(i));
            } else if (list1.get(i).equals("(")) {
                myStack.push(list1.get(i));
            } else if (list1.get(i).equals("+") || list1.get(i).equals("-")) {
                if (list1.get(i).equals("-") && (i == 0 || list1.get(i-1).equals("("))) {
                    list.add("0");
                }
                while (!myStack.isEmpty()) {
                    temp = myStack.pop();
                    if ("(".equals(temp)) {
                        myStack.push(temp);
                        break;
                    }
                    list.add(temp);
                }
                myStack.push(list1.get(i));
            } else if (list1.get(i).equals("*") || list1.get(i).equals("/")) {
                while (!myStack.isEmpty()) {
                    temp = myStack.pop();
                    if ("(".equals(temp) || "+".equals(temp) || "-".equals(temp)) {
                        myStack.push(temp);
                        break;
                    }
                    list.add(temp);
                }
                myStack.push(list1.get(i));
            } else if (list1.get(i).equals(")")) {
                while (!"(".equals(myStack.peek())) {
                    list.add(myStack.pop());
                }
                myStack.pop();
            }
        }

        while (!myStack.isEmpty()) {
            list.add(myStack.pop());
        }
        return list;
    }

    private static boolean isChar(String string) {
        return !(string.equals("+") || string.equals("-") || string.equals("*") || string.equals("/")
                || string.equals("(") || string.equals(")"));
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
            } else if (s.charAt(i) == '(') {
                list.add("(");
                i++;
            } else if (s.charAt(i) == ')') {
                list.add(")");
                i++;
            } else if (s.charAt(i) == '#') {
                break;
            } else {
                StringBuilder str = new StringBuilder();
                while (i < s.length() && s.charAt(i) <= 'z' && s.charAt(i) >= 'a') {
                    str.append(s.charAt(i));
                    i++;
                }
                list.add(str.toString());
            }
        }
        return list;
    }

}
