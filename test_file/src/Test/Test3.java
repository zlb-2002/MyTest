package Test;

import java.io.*;

public class Test3 {

    /*
    需求：从键盘接收两个文件夹路径，把其中一个文件夹拷贝到另一个文件夹中

    分析：
    1.在目标文件家中创建源文件夹
    2.获取源文件家中所有的文件和文件夹，存储在File数组中
    3.遍历数组
    4.如果是文件就用IO流读写
    5.如果是文件夹就递归调用
     */
    public static void main(String[] args) throws IOException {
        File src = Test1.getDir();
        File dest = Test1.getDir();
        if (src.equals(dest)) {
            System.out.println("目标文件是源文件夹的子文件夹！");
        } else {
            copy(src,dest);
        }

    }

    public static void copy(File src, File dest) throws IOException {
        File newDir = new File(dest, src.getName());
        newDir.mkdir();
        File[] subFiles = src.listFiles();
        for (File subFile : subFiles) {
            if(subFile.isFile()) {
               BufferedInputStream bis = new BufferedInputStream(new FileInputStream(subFile));
               BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File(newDir,subFile.getName())));

               int b;
               while((b = bis.read()) != -1) {
                   bos.write(b);
               }

               bis.close();
               bos.close();
            } else {
                copy(subFile,newDir);
            }
        }
    }
}
