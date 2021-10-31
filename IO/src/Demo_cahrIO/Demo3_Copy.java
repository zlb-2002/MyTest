package Demo_cahrIO;

import java.io.*;

public class Demo3_Copy {

    /*
    什么情况下使用字符流？

    字符流也可以拷贝文件，但不推荐使用，因为读取时会把字节转换为字符，写出时还要把字符转会字节。
    程序需要读取一段文本，或者需要写出一段文本的时候可以使用字符流
    读取的时候是按照字符的大小读取的，不会出现半个中文
    写出的时候可以直接将字符串写出，不用转换为字节数组

    字符流不可以拷贝非纯文本的文件
    因为在读的时候会将字节转为字符，在转换的过程中，可能找不到对应的字符，就会用?代替，写出的时候会将字符转成字节写出去
    如果是?，直接写出，这样写出之后的文件就乱了
     */
    public static void main(String[] args) throws IOException {
        //demo1();
        //demo2();
        BufferedReader br = new BufferedReader(new FileReader("xxx.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("yyy.txt"));

        int c;
        while((c = br.read()) != -1) {
            bw.write(c);
        }

        br.close();
        bw.close();
    }

    private static void demo2() throws IOException {
        FileReader fr = new FileReader("xxx.txt");
        FileWriter fw = new FileWriter("yyy.txt");

        int len;
        char[] arr = new char[1024 * 8];
        while((len = fr.read(arr)) != -1) {
            fw.write(arr,0,len);
        }

        fr.close();
        fw.close();
    }

    private static void demo1() throws IOException {
        FileReader fr = new FileReader("xxx.txt");
        FileWriter fw = new FileWriter("yyy.txt");

        int x;
        while((x = fr.read()) != -1) {
            fw.write(x);
        }

        fr.close();
        fw.close();
    }
}
