package test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Test2_UpdateServer {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(12345);
        System.out.println("服务器启动，绑定端口号12345");
        while (true) {
            final Socket socket = server.accept();
            new Thread() {
                @Override
                public void run() {
                    try {
                        InputStream is = socket.getInputStream();
                        BufferedReader br = new BufferedReader(new InputStreamReader(is));
                        PrintStream ps = new PrintStream(socket.getOutputStream());
                        System.out.println("准备就绪");
                        String fileName = br.readLine();
                        System.out.println("文件已经上传，开始创建文件夹");
                        File dir = new File("update");
                        dir.mkdir();
                        File file = new File(dir,fileName);
                        if (file.exists()) {
                            ps.println("存在");
                            socket.close();
                            return;
                        } else {
                            ps.println("不存在");
                        }
                        FileOutputStream fos = new FileOutputStream(file);
                        byte[] arr = new byte[8192];
                        int len;

                        while((len = is.read()) != -1) {
                            fos.write(arr,0,len);
                        }
                        fos.close();
                        socket.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            };

        }
    }

}
