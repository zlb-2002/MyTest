package Test;

import java.io.File;

public class Test4 {

    /*
    从键盘接收一个文件夹路径，把文件夹中的所有文件以及文件夹的名字按层打印
    把文件夹中的所有文件以及文件夹的名字按层级打印
     */
    public static void main(String[] args) {
        File dir = Test1.getDir();
        printLev(dir,0);

    }

    public static void printLev(File dir,int lev) {
        File[] subFiles = dir.listFiles();

        for (File subFile : subFiles) {
            for (int i = 0 ; i <= lev; i++){
                System.out.print("\t");
            }
            System.out.println(subFile);
            if(subFile.isDirectory()) {
                printLev(subFile,lev + 1);
            }
        }
    }


}
