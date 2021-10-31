package otherIO;

import java.io.*;

public class Demo2_ByteArrayOutputStream {

    public static void main(String[] args) throws IOException {
        //Demo1();

        Demo2();
    }

    private static void Demo2() throws IOException {
        //定义一个文件输出流，调用read(byte[] b)方法，将a.txt文件中的内容打印出来（byte数组大小限制为5）
        /*
        分析：
            1.read(byte[] b)是字节输入的流的方法，创建FileInputStream，关联e.txt
            2.创建内存输出流，将读到的数据写到内存输出流中
            3.创建字节数组，长度为5
            4.将内存输出流的数据全部转换为字符串打印
            5.关闭输入流
         */
        FileInputStream fis = new FileInputStream("e.txt");
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        byte[] arr = new byte[5];
        int len;
        while ((len = fis.read(arr)) != -1) {
            baos.write(arr,0,len);
        }

        System.out.println(baos);
        fis.close();
    }

    private static void Demo1() throws IOException {
        FileInputStream fis = new FileInputStream("e.txt");
        ByteArrayOutputStream baos = new ByteArrayOutputStream();     //在内存中创建了可以增长的内存数组

        int b;
        while ((b = fis.read()) != -1) {
            baos.write(b);
        }

        byte[] arr = baos.toByteArray();
        System.out.println(new String(arr));

        System.out.println(baos.toString());        //将缓冲区的内容转换为字符串

        fis.close();

    }

}
