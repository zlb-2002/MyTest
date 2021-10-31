package otherIO;

import java.io.*;

public class Demo7_PrintStream {


    public static void main(String[] args) throws FileNotFoundException {
        //demo1();
        PrintWriter pw = new PrintWriter(new FileOutputStream("f.txt"),true);
        //pw.println(97);             //自动刷出只针对println方法
        //pw.write(97);
        pw.print(97);
        //pw.println(97);
        pw.close();
    }

    private static void demo1() {
        System.out.println("aaa");
        PrintStream ps = System.out;        //获取标准输出流
        ps.println(97);                     //底层通过Integer.toString()将97转换成字符串并打印
        ps.write(97);                    //查找码表，找到对应的a打印
        Person p1 = new Person("张三",23);
        ps.println(p1);                     //打印引用数据类型，如果是null，就打印null，如果不是null就打印toString方法
        ps.close();
    }

}
