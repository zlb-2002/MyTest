package Test;

import java.io.*;
import java.util.ArrayList;

public class Test1 {

    /*
    将一个文本文档上的文本反转，第一行和倒数第一行交换，第二行与当属第二行交换

    分析：
    1.创建输入输出流
    2.创建集合对象
    3.将读到的数据存储在集合中
    4.倒这遍历集合将数据写到文件上
    5.关流

    注意事项：
        流对象尽量晚开早关
     */
    public static void main(String[] args) throws IOException {

        ArrayList<String> list = new ArrayList<>();

        String line;
        BufferedReader br = new BufferedReader(new FileReader("xxx.txt"));

        while((line = br.readLine()) != null) {
            list.add(line);
        }

        br.close();

        //BufferedWriter bw = new BufferedWriter(new FileWriter("yyy.txt"));

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("yyy.txt")));

        for(int i = list.size() - 1; i >= 0;i--) {
            bw.write(list.get(i));
            bw.newLine();
        }

        bw.close();
    }
}
