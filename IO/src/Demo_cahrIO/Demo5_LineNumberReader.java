package Demo_cahrIO;

import java.io.*;

public class Demo5_LineNumberReader {

    //为文件添加一个行号

    public static void main(String[] args) throws IOException {
        LineNumberReader lnr = new LineNumberReader(new FileReader("xxx.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("yyy.txt"));

        String line;
        lnr.setLineNumber(0);
        while((line = lnr.readLine()) != null) {
            bw.write(lnr.getLineNumber() + ":" + line);
            bw.newLine();
        }

        bw.close();
        lnr.close();
    }

}
