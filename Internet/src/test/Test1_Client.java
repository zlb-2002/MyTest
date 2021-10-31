package test;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Test1_Client {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);                          //创建键盘录入对象
        Socket socket = new Socket("127.0.0.1",54321);      //创建客户端，指定IP地址和端口号

        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintStream ps = new PrintStream(socket.getOutputStream());

        ps.println(sc.nextLine());
        System.out.println(br.readLine());

        socket.close();

    }

}
