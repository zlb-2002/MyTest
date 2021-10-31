package Thread3;

import java.util.concurrent.locks.ReentrantLock;

public class Demo2_NotifyAll {

    public static void main(String[] args) {
        final Printer3 p = new Printer3();
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        p.print1();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        p.print2();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        p.print3();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();


    }
}

/*
1.在同步代码块中，用哪个对象锁，就用那个对象调用 wait 方法
2.为什么wait方法和notify方法定义在object这个类中？
    因为锁对象可以是任意对象，Object是所有对象的基类，所以wait方法和notify方法需要定义在Object这个类中
3.sleep方法和wait方法的区别？
    a.sleep方法必须传入参数，参数就是时间值，时间到了就自动醒来
      wait方法可以传入参数，也可以不传入参数，传入参数就是在参数的时间结束后等待，不传入参数就是直接等待
    b.sleep方法在同步函数或同步代码块中，不释放锁
      wait方法在同步函数或者同步代码块中，释放锁

 */

class Printer3 {
    private int flag = 1;
    public void print1() throws InterruptedException {
        synchronized (this) {
            while (flag != 1) {
                this.wait();
            }
            System.out.print("程");
            System.out.print("序");
            System.out.print("员");
            System.out.print("\r\n");
            flag = 2;
            this.notifyAll();
        }
    }

    public void print2() throws InterruptedException {

        synchronized (this) {
            while (flag != 2) {
                this.wait();
            }
            System.out.print("学");
            System.out.print("生");
            System.out.print("\r\n");
            flag = 3;
            this.notifyAll();
        }
    }

    public void print3() throws InterruptedException {
        synchronized (this) {
            while (flag != 3) {
                this.wait();
            }
            System.out.print("老");
            System.out.print("师");
            System.out.print("\r\n");
            flag = 1;
            this.notifyAll();
        }
    }



}

