package otherIO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Demo3_RandomAccessFile {

    public static void main(String[] args) throws IOException {
        Demo1();
    }

    private static void Demo1() throws IOException {
        RandomAccessFile raf = new RandomAccessFile("e.txt","rw");
        raf.write(97);
        raf.seek(10);           //在指定位置设置指针
        raf.write(98);
    }

}
