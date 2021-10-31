package Thread2;

import java.io.IOException;

public class Demo2_Runtime {

    public static void main(String[] args) throws IOException, InterruptedException {
        Runtime r = Runtime.getRuntime();           //获取Runtime对象
        r.exec("shutdown -s -t 300");
        Thread.sleep(3000);
        r.exec("shutdown -a");
        System.out.println("已取消关闭");
    }

}
