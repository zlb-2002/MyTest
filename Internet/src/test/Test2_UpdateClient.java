package test;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Test2_UpdateClient {

    /*
    1.提示输入要上传的文件路径，验证路径是否存在以及是否是文件夹
    2.发送文件到服务器
    3.接收结果，如果存在给予提示，程序直接退出
    4.如果不存在，定义FileinputStream读取文件，写出到网络
     */
    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("127.0.0.1",12345);
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintStream ps = new PrintStream(socket.getOutputStream());
        File file = getFile();
        ps.println(file.getName());
        System.out.println("文件已上传");
        String result = br.readLine();
        if ("存在".equals(result)) {
            System.out.println("您上传的文件已经存在，请不要重复上传！");
            return ;
        }

        FileInputStream fis = new FileInputStream(file);
        byte[] arr = new byte[8192];
        int len;

        System.out.println("文件开始上传");
        while ((len = fis.read(arr)) != -1) {
            ps.write(arr,0, len);
        }
        fis.close();
        socket.close();
    }

    private static File getFile() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个文件路径：");
        while (true) {
            String line = sc.nextLine();
            File file = new File(line);

            if (!file.exists()) {
                System.out.println("文件不存在，请重新录入：");
            } else if (file.isDirectory()) {
                System.out.println("您录入的是文件夹路径，请输入一个文件路经：");
            } else {
                return file;
            }
        }

    }

}
