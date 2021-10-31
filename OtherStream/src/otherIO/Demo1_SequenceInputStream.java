package otherIO;

import java.io.*;
import java.util.Enumeration;
import java.util.Vector;

public class Demo1_SequenceInputStream {

    public static void main(String[] args) throws IOException {
        //Demo1();
        Demo2();
    }

    private static void Demo2() throws IOException {
        FileInputStream fis1 = new FileInputStream("xxx.txt");
        FileInputStream fis2 = new FileInputStream("yyy.txt");
        FileInputStream fis3 = new FileInputStream("zzz.txt");

        Vector<FileInputStream> v = new Vector<>();
        v.add(fis1);
        v.add(fis2);
        v.add(fis3);


        Enumeration<FileInputStream> en = v.elements();
        SequenceInputStream sis = new SequenceInputStream(en);
        FileOutputStream fos = new FileOutputStream("c.txt");

        int b;
        while ((b = sis.read()) != -1) {
            fos.write(b);
        }

        sis.close();
        fos.close();
    }

    private static void Demo1() throws IOException {
        FileInputStream fis1 = new FileInputStream("xxx.txt");
        FileInputStream fis2 = new FileInputStream("yyy.txt");
        SequenceInputStream sis = new SequenceInputStream(fis1,fis2);

        FileOutputStream fos = new FileOutputStream("c.txt");
        int b;
        while ((b = sis.read()) != -1) {
            fos.write(b);
        }
        sis.close();
        fos.close();
    }

}
