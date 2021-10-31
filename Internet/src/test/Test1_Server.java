package test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Test1_Server {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(54321);
        System.out.println("��������������54321");

        while (true) {
            final Socket socket = server.accept();

            new Thread() {
                @Override
                public void run() {
                    try {
                        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        PrintStream ps = new PrintStream(socket.getOutputStream());     //��ȡ������

                        String line = br.readLine();
                        line = new StringBuffer(line).reverse().toString();
                        ps.println(line);       //��ת��д��ȥ
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }.start();

        }
    }

}
