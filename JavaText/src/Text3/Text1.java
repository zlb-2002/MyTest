package Text3;

import java.util.*;

public class Text1 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ns = null;
        int j = 0;
        ns = sc.nextLine();
        String s = sc.nextLine();
        int n = Integer.parseInt(ns);
        String[] strings = new String[2*n];
        StringBuilder sb = new StringBuilder();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9' || s.charAt(i) == '-') {
                sb.append(s.charAt(i));
            } else if (s.charAt(i) == ',' || s.charAt(i) == ')') {
                strings[j++] = sb.toString();
                sb.delete(0, sb.length());
            }
        }

        for (int i = 0;i < 2*n;i=i+2) {
            map.put(Integer.parseInt(strings[i+1]), Integer.parseInt(strings[i]));
        }
        sb.delete(0, sb.length());
        for (Integer i : map.keySet()) {
            if (sb.length() == 0) {
                if (i == 0) {
                    sb.append(map.get(i));
                } else if (i == 1) {
                    sb.append(map.get(i)).append("X");
                } else {
                    sb.append(map.get(i)).append("X^").append(i);
                }
                continue;
            } else {
                if (i == 0) {
                    if (map.get(i) > 0) {
                        sb.append("+").append(map.get(i));
                    } else {
                        sb.append(map.get(i));
                    }
                } else if (i == 1) {
                    if (map.get(i) > 0) {
                        sb.append("+").append(map.get(i)).append("X");
                    } else {
                        sb.append(map.get(i)).append("X");
                    }
                } else {
                    if (map.get(i) > 0) {
                        sb.append("+").append(map.get(i)).append("X^").append(i);
                    } else {
                        sb.append(map.get(i)).append("X^").append(i);
                    }
                }
            }
        }
        System.out.print(sb.toString());
    }



}
