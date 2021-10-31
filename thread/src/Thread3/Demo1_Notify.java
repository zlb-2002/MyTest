package Thread3;



public class Demo1_Notify {

    /*
    等待唤醒机制
     */

    public static void main(String[] args) {
        final Printer2 p = new Printer2();
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
    }

}
class Printer2 {
    private int flag = 1;
    public void print1() throws InterruptedException {
        synchronized (this) {
            if(flag != 1) {
                this.wait();
            }
            System.out.print("程");
            System.out.print("序");
            System.out.print("员");
            System.out.print("\r\n");
            flag = 2;
            this.notify();
        }
    }

    public void print2() throws InterruptedException {

        synchronized(this) {
            if (flag != 2) {
                this.wait();
            }
            System.out.print("学");
            System.out.print("生");
            System.out.print("\r\n");
            flag = 1;
            this.notify();
        }

    }

}
