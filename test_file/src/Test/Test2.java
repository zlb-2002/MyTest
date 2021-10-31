package Test;



import java.io.File;

public class Test2 {

    /*
    删除该文件夹

    分析：
    1.获取该文件夹下所有的文件和文件夹
    2.遍历数组
    3.判断是文件直接删除
    4.如果是文件夹，递归调用
    5.循环结束后，把空文件夹删掉
     */
    public static void main(String[] args) {
        File dir = Test1.getDir();
        deleteFile(dir);
    }

    public static void deleteFile(File dir) {
        File[] subFiles = dir.listFiles();

        for (File subFile : subFiles) {
            if(subFile.isFile()) {
                subFile.delete();
            } else {
                deleteFile(subFile);
            }
        }

        dir.delete();
    }
}
