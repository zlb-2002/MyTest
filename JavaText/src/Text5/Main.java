package Text5;

import java.util.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String number1 = sc.nextLine();
        String string1 = sc.nextLine();
        String number2 = sc.nextLine();
        String string2 = sc.nextLine();

        List<Matrix> list1 = change(string1);
        List<Matrix> list2 = change(string2);

        list1.remove(list1.size()-1);
        list2.remove(list2.size()-1);

        String s1 = number1.substring(0,4);
        String s2 = number2.substring(0,4);

        List<Matrix> list = addMatrix(list1, list2);
        s1 = s1 + list.size();
        System.out.println(s1);
        print(list);
        list = subtractMatrix(list1, list2);
        s2 = s2 + list.size();
        System.out.println(s2);
        print(list);
    }

    public static void print (List<Matrix> list) {
        for (Matrix matrix : list) {
            System.out.print(matrix);
        }
        System.out.println();
    }

    public static List<Matrix> addMatrix (List<Matrix> list1, List<Matrix> list2) {
        int i = 0;
        int j = 0;
        List<Matrix> list = new ArrayList<>();
        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i).x == list2.get(j).x && list1.get(i).y == list2.get(i).y) {
                Matrix matrix = new Matrix();
                matrix.x = list1.get(i).x;
                matrix.y = list1.get(i).y;
                matrix.val = list1.get(i).val + list2.get(j).val;
                list.add(matrix);
                i++;
                j++;
            } else if (list1.get(i).x == list2.get(j).x && list1.get(i).y < list2.get(j).y) {
                list.add(list1.get(i++));
            } else if (list1.get(i).x == list2.get(j).x && list1.get(i).y > list2.get(j).y) {
                list.add(list2.get(j++));
            } else if (list1.get(i).x > list2.get(j).x) {
                list.add(list2.get(j++));
            } else if (list1.get(i).x < list2.get(j).x) {
                list.add(list1.get(i++));
            }
        }
        if (list1.size() > i) {
            while (i < list1.size()) {
                list.add(list1.get(i++));
            }
        }
        if (list2.size() > j) {
            while (j < list2.size()) {
                list.add(list2.get(j++));
            }
        }
        for (int i1 = 0; i1 < list.size();) {
            if (list.get(i1).val == 0) {
                list.remove(i1);
            } else {
                i1++;
            }
        }
        return list;
    }
    public static List<Matrix> subtractMatrix (List<Matrix> list1, List<Matrix> list2) {
        int i = 0;
        int j = 0;
        List<Matrix> list = new ArrayList<>();
        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i).x == list2.get(j).x && list1.get(i).y == list2.get(i).y) {
                Matrix matrix = new Matrix();
                matrix.x = list1.get(i).x;
                matrix.y = list1.get(i).y;
                matrix.val = list1.get(i).val - list2.get(j).val;
                list.add(matrix);
                i++;
                j++;
            } else if (list1.get(i).x == list2.get(j).x && list1.get(i).y < list2.get(j).y) {
                list.add(list1.get(i++));
            } else if (list1.get(i).x == list2.get(j).x && list1.get(i).y > list2.get(j).y) {
                Matrix matrix = new Matrix();
                matrix.x = list2.get(j).x;
                matrix.y = list2.get(j).y;
                matrix.val = -list2.get(j).val;
                list.add(matrix);
                j++;
            } else if (list1.get(i).x > list2.get(j).x) {
                Matrix matrix = new Matrix();
                matrix.x = list2.get(j).x;
                matrix.y = list2.get(j).y;
                matrix.val = -list2.get(j).val;
                list.add(matrix);
                j++;
            } else if (list1.get(i).x < list2.get(j).x) {
                list.add(list1.get(i++));
            }
        }
        if (list1.size() > i) {
            while (i < list1.size()) {
                list.add(list1.get(i++));
            }
        }
        if (list2.size() > j) {
            while (j < list2.size()) {
                Matrix matrix = new Matrix();
                matrix.x = list2.get(j).x;
                matrix.y = list2.get(j).y;
                matrix.val = -list2.get(j).val;
                list.add(matrix);
                j++;
            }
        }
        for (int i1 = 0; i1 < list.size();) {
            if (list.get(i1).val == 0) {
                list.remove(i1);
            } else {
                i1++;
            }
        }
        return list;
    }

    public static List<Matrix> change (String string) {
        StringBuilder sb = new StringBuilder(string);
        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < sb.length(); i++) {
            StringBuilder sb1 = new StringBuilder();
            while (isNumber(sb.charAt(i))) {
                sb1.append(sb.charAt(i));
                i++;
            }
            if (sb1.length() != 0) {
                list.add(sb1);
            }

        }
        List<Matrix> matrices = new ArrayList<>();
        for (int i = 0; i < (list.size()/3+1);i++) {
            matrices.add(new Matrix());
        }
        for (int i = 0;i < list.size();i++) {
            if (i%3 == 0) {
                matrices.get(i/3).x = Integer.parseInt(list.get(i).toString());
            } else if (i%3 == 1) {
                matrices.get(i/3).y = Integer.parseInt(list.get(i).toString());
            } else {
                matrices.get(i/3).val = Integer.parseInt(list.get(i).toString());
            }
        }
        return matrices;
    }

    private static boolean isNumber(char c) {
        return  c <= '9' && c >= '0' || c == '-';
    }

    private static boolean isNumber() {
        return  true;
    }

    static class Matrix {
        int x;
        int y;
        int val;
        @Override     //ÖØÐ´
        public String toString() {
            return "("+x+","+y+","+val+")";
        }
    }

}
