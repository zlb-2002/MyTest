package TCP;

import java.io.*;
import java.net.Socket;

public class Demo2_Client {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",12345);

        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintStream ps = new PrintStream(socket.getOutputStream());     //printStream中有写出换行的方法

        System.out.println(br.readLine());
        ps.println("我想报名西安邮电大学");
        System.out.println(br.readLine());
        ps.println("能不能给个机会？");
        socket.close();

    }


}
