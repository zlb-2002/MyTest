package Text3;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Text3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n1 = null;
        String n2 = null;
        n1 = sc.nextLine();
        String s1 = sc.nextLine();
        n2 = sc.nextLine();
        String s2 = sc.nextLine();
        TreeMap<Integer, Integer> map1 = getMap(n1, s1);
        TreeMap<Integer, Integer> map2 = getMap(n2, s2);
        TreeMap<Integer, Integer> map = new TreeMap<>();
        while (!map1.isEmpty() && !map2.isEmpty()) {
            if (map1.firstKey() > map2.firstKey()) {
                map.put(map2.firstKey(), map2.get(map2.firstKey()));
                map2.remove(map2.firstKey());
            } else if (map1.firstKey() == map2.firstKey()) {
                if ((map1.get(map1.firstKey()) - map2.get(map2.firstKey())) != 0) {
                    map.put(map1.firstKey(), map1.get(map1.firstKey())-map2.get(map2.firstKey()));
                }
                map1.remove(map1.firstKey());
                map2.remove(map2.firstKey());
            } else {
                map.put(map1.firstKey(), map1.get(map1.firstKey()));
                map1.remove(map1.firstKey());
            }
        }
        if (map1.isEmpty()) {
            map.putAll(map2);
        } else {
            map.putAll(map1);
        }
        print(map, map.size());
    }
    public static void print (Map<Integer, Integer> map, int n) {
        StringBuilder sb = new StringBuilder();
        for (Integer i : map.keySet()) {
            if (sb.length() == 0) {
                if (i == 0) {
                    sb.append(map.get(i));
                } else if (i == 1) {
                    if (map.get(i) == 1) {
                        sb.append("X");
                    } else {
                        sb.append(map.get(i)).append("X");
                    }

                } else {
                    if (map.get(i) == 1) {
                        sb.append("X^").append(i);
                    } else {
                        sb.append(map.get(i)).append("X^").append(i);
                    }
                }
            } else {
                if (i == 0) {
                    if (map.get(i) > 0) {
                        sb.append("+").append(map.get(i));
                    } else {
                        sb.append(map.get(i));
                    }
                } else if (i == 1) {
                    if (map.get(i) > 0) {
                        if (map.get(i) == 1) {
                            sb.append("+").append("X");
                        } else {
                            sb.append("+").append(map.get(i)).append("X");
                        }
                    } else {
                        if (map.get(i) == 1) {
                            sb.append("X");
                        } else {
                            sb.append(map.get(i)).append("X");
                        }
                    }
                } else {
                    if (map.get(i) > 0) {
                        if (map.get(i) == 1) {
                            sb.append("+").append("X^").append(i);
                        } else {
                            sb.append("+").append(map.get(i)).append("X^").append(i);
                        }
                    } else {
                        if (map.get(i) == 1) {
                            sb.append("X^").append(i);
                        } else {
                            sb.append(map.get(i)).append("X^").append(i);
                        }
                    }
                }
            }
        }
        System.out.print(sb.toString());
    }

    public static TreeMap<Integer, Integer> getMap (String n1, String s) {
        int n = Integer.parseInt(n1);
        String[] strings = new String[2*n];
        int j = 0;
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
        return map;
    }
}
