package test;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Test1_Client {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);                          //��������¼�����
        Socket socket = new Socket("127.0.0.1",54321);      //�����ͻ��ˣ�ָ��IP��ַ�Ͷ˿ں�

        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintStream ps = new PrintStream(socket.getOutputStream());

        ps.println(sc.nextLine());
        System.out.println(br.readLine());

        socket.close();

    }

}
