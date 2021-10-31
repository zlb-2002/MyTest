package Thread3;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Demo3_ReentrantLock {

    public static void main(String[] args) {
        Printer4 p = new Printer4();

        new Thread() {
            @Override
            public void run() {
                try {
                    p.print1();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                try {
                    p.print2();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                try {
                    p.print3();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

}
class Printer4 {
    private ReentrantLock r = new ReentrantLock();
    private Condition c1 = r.newCondition();
    private Condition c2 = r.newCondition();
    private Condition c3 = r.newCondition();
    private int flag = 1;
    public void print1() throws InterruptedException {
        r.lock();
            if (flag != 1) {
                c1.await();
            }
            System.out.print("程");
            System.out.print("序");
            System.out.print("员");
            System.out.print("\r\n");
            flag = 2;
            c2.signal();
        r.unlock();
    }

    public void print2() throws InterruptedException {

        r.lock();
            if (flag != 2) {
                c2.await();
            }
            System.out.print("学");
            System.out.print("生");
            System.out.print("\r\n");
            flag = 3;
            c2.signal();
        r.unlock();
    }

    public void print3() throws InterruptedException {
        r.lock();
            if (flag != 3) {
                c3.await();
            }
            System.out.print("老");
            System.out.print("师");
            System.out.print("\r\n");
            flag = 1;
            c1.signal();
        r.unlock();
    }



}


