package Test;

import java.io.*;

public class Test3 {

    /*
    当我们下载一个试用版软件，没有购买正版的时候，每一次执行就会提醒我们还有多少次机会用学过的IO知识，模拟试用版软件，
    试用10次机会，执行一次就提示还有几次机会，如果次数到了提示购买正版
    分析：
    1.创建带缓冲的输入流对象，因为要使用readLine()方法，可以保证数据的原样性
    2.将读取的字符串转换为int数
    3.对int数进行判断，如果大于0，就将其写回去，如果不大于0，就提示请购买正版
    4.在if判断中要将结果打印，并将结果通过输出流写到文件上
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("config.txt"));
        String line = br.readLine();
        int times = Integer.parseInt(line);
        if (times > 0) {
            System.out.println("您还有" + times + "次机会！");
            times--;
            FileWriter fw = new FileWriter("config.txt");
            fw.write(times + "");
            fw.close();
        } else {
            System.out.println("您的试用机会已用完，请购买正版！");
        }

    }

}
