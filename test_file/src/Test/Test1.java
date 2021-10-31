package Test;

import java.io.File;
import java.util.Scanner;

public class Test1 {

    /*
    需求：从键盘路入一个文件夹路径，统计文件夹大小

     */
    public static void main(String[] args) {
        File dir = getDir();
        System.out.println(getFileLength(dir));
    }

    public static File getDir() {
        Scanner sc = new Scanner(System.in);
        String line;
        System.out.println("请输入一个文件夹路径:");
        while (true) {
            line = sc.nextLine();
            File dir = new File(line);
            if (!(dir.exists())) {
                System.out.println("您输入的文件夹路径不存在，请重新录入:");
            } else if (dir.isFile()) {
                System.out.println("您输入的是一个文件路径，请输入一个文件夹路径:");
            } else if (dir.isDirectory()){
                return dir;
            }
        }
    }

    public static long getFileLength(File dir) {
        long len = 0;
        File[] subFiles = dir.listFiles();
        for(File subFile : subFiles) {
            if (subFile.isFile()) {
                len = len + subFile.length();
            } else {
                getFileLength(subFile);
            }
        }
        return len;
    }
}
