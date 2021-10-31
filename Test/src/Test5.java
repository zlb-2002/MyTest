
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Stack;

public class Test5 {

    public static int flag1 = 2;
    public static StringBuilder stringBuilder = new StringBuilder("(2*(1+2");

    public static void main(String[] args) {
        String result = countResult(change2(change1()));
        stringBuilder.delete(0, stringBuilder.length());
        stringBuilder.append(result);
        System.out.println(stringBuilder);
        /*ArrayList<String> al = change1();
        System.out.println(al);*/
    }

    private static String countResult(ArrayList<String> list) {
        Stack<BigDecimal> myStack = new Stack<>();
        BigDecimal bigDecimal_1, bigDecimal_2;
        for (String string : list) {
            if (isNumber(string)) {
                myStack.push(new BigDecimal(string));
            } else {
                bigDecimal_1 = myStack.pop();
                bigDecimal_2 = myStack.pop();
                switch (string) {
                    case "+" :
                        myStack.push(bigDecimal_1.add(bigDecimal_2));
                        break;
                    case "-" :
                        myStack.push(bigDecimal_2.subtract(bigDecimal_1));
                        break;
                    case "*" :
                        myStack.push(bigDecimal_1.multiply(bigDecimal_2));
                        break;
                    case "/" :
                        myStack.push(bigDecimal_2.divide(bigDecimal_1,5,BigDecimal.ROUND_HALF_UP));
                        break;
                }
            }
        }


        return deleteZero(myStack.pop().toString());

    }

    public static String deleteZero (String string) {

        if (string.indexOf(".") > 0) {
            string = string.replaceAll("0+?$","");
            string = string.replaceAll("[.]$","");
        }
        return string;
    }

    private static boolean isNumber(String string) {
        return !(string.equals("+") || string.equals("-") || string.equals("*") || string.equals("/")
                || string.equals("(") || string.equals(")"));
    }

    private static ArrayList<String> change1() {

        ArrayList<String> list = new ArrayList<>();
        while (flag1 > 0) {
            stringBuilder.append(")");
            flag1--;
        }
        String str = stringBuilder.toString();
        String s = "";
        for (int i = 0; i < str.length(); ) {
            if (str.charAt(i) == '(') {
                list.add(str.substring(i, i+1));
                i++;
                continue;
            }
            if (str.charAt(i) == '+') {
                list.add(str.substring(i, i+1));
                i++;
                continue;
            }
            if (str.charAt(i) == '-') {
                if (!(i != 0 && (str.charAt(i-1) == '*' || str.charAt(i-1) == '/'))) {
                    list.add(str.substring(i, i+1));
                    i++;
                    continue;
                }

            }

            if (str.charAt(i) == '*') {
                list.add(str.substring(i, i+1));
                i++;
                continue;
            }
            if (str.charAt(i) == '/') {
                list.add(str.substring(i, i+1));
                i++;
                continue;
            }
            if (str.charAt(i) == ')') {
                list.add(str.substring(i, i+1));
                i++;
                continue;
            }
            while (i < str.length() && ((str.charAt(i) <= '9' && str.charAt(i) >= '0') ||
                    str.charAt(i) == '.' ||
                    (str.charAt(i) == '-' && (str.charAt(i-1) == '*' || str.charAt(i-1) == '/')))) {
                s = s + str.charAt(i);
                i++;
            }
            list.add(s);
            s = "";
        }
        return list;
    }

    private static ArrayList<String> change2(ArrayList<String> list1) {
        ArrayList<String> list = new ArrayList<>();
        Stack<String> myStack = new Stack<>();
        String temp;
        for (int i = 0;i < list1.size();i++) {
            if (isNumber(list1.get(i))) {
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
}
