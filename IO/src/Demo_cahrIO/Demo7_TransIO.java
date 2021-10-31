package Demo_cahrIO;


import java.io.*;

public class Demo7_TransIO {

    public static void main(String[] args) throws IOException {
        //demo1();
        //demo2();
        BufferedReader br = new BufferedReader(new InputStreamReader    //更高效的读
                (new FileInputStream("utf-8.txt"),"utf-8"));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter   //更高效的写
                (new FileOutputStream("gbk.txt"),"gbk"));

        int c;
        while((c = br.read()) != -1) {
            bw.write(c);
        }

        br.close();
        bw.close();
    }

    private static void demo2() throws IOException {
        InputStreamReader isr = new InputStreamReader(new FileInputStream("utf-8.txt"),"utf-8");
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("gbk.txt"),"gbk");

        int c;
        while((c = isr.read()) != -1) {
            osw.write(c);
        }

        isr.close();
        osw.close();
    }

    private static void demo1() throws IOException {
        //用默认编码表读写，会出现乱码
        FileReader fr = new FileReader("utf-8.txt");
        FileWriter fw = new FileWriter("gbk.txt");

        int c;
        while((c = fr.read()) != -1) {
            fw.write(c);
        }

        fr.close();
        fw.close();
    }
}
