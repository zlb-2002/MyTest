package TCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Demo1_Server {

    public static void main(String[] args) throws IOException {


        ServerSocket server = new ServerSocket(12345);

        Socket socket = server.accept();             //接受客户端的请求
        InputStream is = socket.getInputStream();       //获取客户端的输入流
        OutputStream os = socket.getOutputStream();     //获取客户端的输出流

        os.write("百度一下你就知道".getBytes());            //服务器向客户端写出数据

        byte[] arr = new byte[1024];
        int len = is.read(arr);                           //读取服务器发过来的数据
        System.out.println(new String(arr,0,len));  //将数据转换成字符串并打印

        socket.close();


    }

}
