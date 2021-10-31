package Text2;

import java.io.*;

public class Text {

    public static void main(String[] args) throws IOException {
        File dir = new File("C:\\Users\\86183\\Desktop", "Í¼±ê");
        File dest = new File("D:\\ÐÂÕÕÆ¬");
        copyPhoto(dir, dest);
    }

    public static void copyPhoto (File dir, File dest) throws IOException {
        File newDir = new File(dest, dir.getName());
        newDir.mkdir();
        File[] files = dir.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                copyPhoto(file,dest);
            } else if (file.isFile()) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(newDir, file.getName()))));
                int i;
                while ((i = bufferedReader.read()) != -1) {
                    bufferedWriter.write(i);
                }
                bufferedReader.close();
                bufferedWriter.close();
            }
        }
    }
}
