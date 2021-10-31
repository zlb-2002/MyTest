package TCP;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Demo2_Server {

    public static void main(String[] args) throws IOException {


        //Demo1();
        ServerSocket server = new ServerSocket(12345);
        while (true) {
            final Socket socket = server.accept();
            new Thread() {
                public void run() {
                    try{
                        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        PrintStream ps = new PrintStream(socket.getOutputStream());

                        ps.println("欢迎报考西安邮电大学");
                        System.out.println(br.readLine());
                        ps.println("不好意思，报满了");
                        System.out.println(br.readLine());
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            };

        }

    }

    private static void Demo1() throws IOException {
        ServerSocket server = new ServerSocket(12345);

        Socket socket = server.accept();             //接受客户端的请求

        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintStream ps = new PrintStream(socket.getOutputStream());

        ps.println("欢迎报考西安邮电大学");
        System.out.println(br.readLine());
        ps.println("不好意思，报满了");
        System.out.println(br.readLine());
        socket.close();
    }

}
