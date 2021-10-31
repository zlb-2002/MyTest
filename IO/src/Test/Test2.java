package Test;

import java.io.*;
import java.util.TreeMap;

public class Test2 {
    /*
    获取一个文本上的每个字符出现的次数，将结果写在times.txt上

    分析：
    1.创建带缓冲区的输入流对象
    2.创建双列结合对象TreeMap
    3.将读到的字符存储在双双列集合中，存储的时候要做判断，如果不包含这个键，就将键和1存储，如果包含这个键，就将该键和值加一存储
    4.关闭输入流
    5.创建输出流对象
    6.遍历集合将集合中的内容写到times.txt中
    7.关闭输出流
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("xxx.txt"));

        TreeMap<Character,Integer> tm = new TreeMap<>();

        int ch;
        while((ch = br.read()) != -1) {
            char c = (char)ch;
            /*if(!tm.containsKey(c)) {
                tm.put(c,1);
            } else {
                tm.put(c,tm.get(c) + 1);
            }*/
            tm.put(c,tm.containsKey(c) ? tm.get(c) + 1 : 1);
        }
        br.close();

        BufferedWriter bw = new BufferedWriter(new FileWriter("times.txt"));

        for (Character key : tm.keySet() ) {
            switch (key) {
                case ' ':
                    bw.write("\\t" + ":" + tm.get(key));
                    break;
                case '\r':
                    bw.write("\\r" + ":" + tm.get(key));
                    break;
                case '\n':
                    bw.write("\\n" + ":" + tm.get(key));
                    break;
                default:
                    bw.write(key + ":" + tm.get(key));
            }
            bw.newLine();

        }

        bw.close();
    }
}
