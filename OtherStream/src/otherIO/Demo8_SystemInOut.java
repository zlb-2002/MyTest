package otherIO;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

public class Demo8_SystemInOut {

    public static void main(String[] args) throws IOException {
        //demo1();
        System.setIn(new FileInputStream("a.txt"));
        System.setOut(new PrintStream("b.txt"));

        InputStream is = System.in;
        PrintStream ps = System.out;

        int b;
        while ((b = is.read()) != -1) {
            ps.write(b);
        }

        is.close();
        ps.close();
    }

    private static void demo1() throws IOException {
        InputStream is = System.in;
        int x = is.read();
        System.out.println(x);

        is.close();

        InputStream is2 = System.in;
        int y = is2.read();
        System.out.println(y);
    }


}
