package syn;

public class Demo4_Ticket {

    public static void main(String[] args) {
        MyTicket mt = new MyTicket();
        new Thread(mt).start();
        new Thread(mt).start();
        new Thread(mt).start();
        new Thread(mt).start();
        /*Thread t1 = new Thread(mt);
        t1.start();
        t1.start();
        t1.start();
        t1.start();*/   //不能多次启动一个线程，多次启动一个线程是非法的，东一个线程结束后就不能重新开启
    }

}

class MyTicket implements Runnable {
    private int ticket = 100;


    @Override
    public void run() {

        while (true) {
            synchronized (this) {
                if (ticket == 0) {
                    break;
                }
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "...这是第" + ticket-- + "号票");
            }

        }
    }
}