package Demo_cahrIO;

import java.io.*;

public class Demo4_Buffered {

    /*
    带缓冲区的特殊方法
    readLine();
    newLine();

    newLine()与\r\n的区别
    newLine()是跨平台的方法
    \r\n只支持Windows系统
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("xxx.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("yyy.txt"));

        String line;
        while((line = br.readLine()) != null) {
            bw.write(line);
            bw.newLine();
        }

        br.close();
        bw.close();

    }
}
