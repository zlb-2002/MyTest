package Demo_cahrIO;

import java.io.FileWriter;
import java.io.IOException;

public class Demo2_FileWriter {

    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("yyy.txt");
        fw.write("大家好，这一学期接近尾声了，要坚持！！！");
        fw.write(97);
        fw.close();
    }
}

