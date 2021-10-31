package TCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Demo1_Server {

    public static void main(String[] args) throws IOException {


        ServerSocket server = new ServerSocket(12345);

        Socket socket = server.accept();             //���ܿͻ��˵�����
        InputStream is = socket.getInputStream();       //��ȡ�ͻ��˵�������
        OutputStream os = socket.getOutputStream();     //��ȡ�ͻ��˵������

        os.write("�ٶ�һ�����֪��".getBytes());            //��������ͻ���д������

        byte[] arr = new byte[1024];
        int len = is.read(arr);                           //��ȡ������������������
        System.out.println(new String(arr,0,len));  //������ת�����ַ�������ӡ

        socket.close();


    }

}
