
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;


public class Server1 {

    private static final int port = 12345;
    private static HashMap<String,Socket> hm;
    private static ServerSocket server;

    public static void main(String[] args) throws IOException {
        hm = new HashMap<>();
        startServer();
    }

    public static void startServer() throws IOException {
        new Thread() {
            @Override
            public void run() {
                try {
                    server = new ServerSocket(port);
                    while (true) {
                        Socket socket = server.accept();
                        System.out.println(1);
                        StringBuilder sb = new StringBuilder(socket.getInetAddress().toString());
                        sb.deleteCharAt(0);
                        hm.put(sb.toString(), socket);
                        System.out.println(sb.toString());
                        handle(socket);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }.start();

    }

    private static void handle(Socket socket) throws IOException {

        new Thread() {
            @Override
            public void run() {
                try {
                    while (true) {
                        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        String content = br.readLine();
                        String ip = br.readLine();
                        String time = br.readLine();

                        if ("255.255.255.255".equals(ip)) {
                            System.out.println("发给全部人");
                            String str = null;
                            for (String sendIP : hm.keySet()) {
                                try {
                                    StringBuilder sb = new StringBuilder(socket.getInetAddress().toString());
                                    sb.deleteCharAt(0);
                                    str = sb.toString();
                                    if (str.equals(sendIP)) {
                                        continue;
                                    }
                                    Socket s = hm.get(sendIP);
                                    PrintStream ps = new PrintStream(s.getOutputStream(), true, "GBK");
                                    ps.println(content);
                                    System.out.println(content);
                                    ps.println(time);
                                    ps.println(str);
                                } catch (Exception e) {
                                    hm.remove(str);
                                }

                            }
                            System.out.println("发完了");
                        } else {
                            Socket s = null;
                            for (String sendIP : hm.keySet()) {
                                try {
                                    if (ip.equals(sendIP)) {
                                        s = hm.get(sendIP);
                                        break;
                                    }
                                } catch (Exception e) {
                                    hm.remove(ip);
                                }
                            }
                            if (s != null) {
                                StringBuilder sb = new StringBuilder(socket.getInetAddress().toString());
                                String str = sb.deleteCharAt(0).toString();
                                PrintStream ps = new PrintStream(s.getOutputStream(), true, "GBK");
                                ps.println(content);
                                System.out.println(content);
                                ps.println(time);
                                ps.println(str);

                                System.out.println("发送给" + socket.getInetAddress());

                            }
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();


    }


}
