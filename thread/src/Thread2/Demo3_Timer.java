package Thread2;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Demo3_Timer {

    public static void main(String[] args) throws InterruptedException {
        Timer t = new Timer();
        //在指定时间安排指定任务
        //第一个参数是安排任务，第二个参数是执行的时间，第三个参数是多长时间再重复执行
        t.schedule(new MyTimetask(),new Date(121,5,19,19,13,10),3000);
        while (true) {
            Thread.sleep(1000);
            System.out.println(new Date());
        }
    }

}

class MyTimetask extends TimerTask {
    @Override
    public void run() {
        System.out.println("起床背英语单词");
    }
}
