package Test;

import java.io.File;
import java.util.Scanner;

public class Test4 {

    /*
    从键盘接收一个文件夹路径，打印出该文件夹下所有的.java文件名

    分析：
    从键盘接收一个文件夹路径
    1.如果录入的是不存在的，给予提示
    2.如果录入的是文件路径，给予提示
    3.如果录入的是文件夹路径，直接返回

    打印出该文件夹下所有的.java文件名
    1.获取到给文件夹路径下所有的文件和文件夹，存储在File数组中
    2.遍历数组，对每一个文件或文件夹判断
    3.如果是文件夹，并且后缀是.java文件的，就打印
    4.如果是文件夹，就递归调用
     */
    public static void main(String[] args) {
        File dir = getDir();
        getJava(dir);
    }

    public static void getJava(File dir) {
        File[] subFiles = dir.listFiles();
        for (File subFile : subFiles) {
            if(subFile.isFile() && subFile.getName().endsWith(".java")) {
                System.out.println(subFile);
            } else if (subFile.isDirectory()) {
                getJava(subFile);
            }
        }
    }


    public static File getDir() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个文件夹路径：");
        while (true) {
            String line = sc.nextLine();
            File dir = new File(line);
            if (!dir.exists()) {
                System.out.println("输入的文件夹路径不存在，请重新录入：");
            } else if(dir.isFile()) {
                System.out.println("您输入的是文件路径，请重新输入一个文件夹路径：");
            } else {
                return dir;
            }

        }
    }
}
