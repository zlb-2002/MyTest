package syn;

public class Demo1_Synchronized {

    public static void main(String[] args) {
        Printer p = new Printer();

        new Thread() {
            @Override
            public void run() {
                while (true) {
                    p.print1();
                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                while (true) {
                    p.print2();
                }
            }
        }.start();

    }

}

class Printer {
    Demo d = new Demo();
    public void print1() {
        //同步代码块，锁机制，锁对象是任意的
        synchronized(d) {
            System.out.print("程");
            System.out.print("序");
            System.out.print("员");
            System.out.print("\r\n");
        }
    }

    public void print2() {
        //锁对象不能用匿名对象，因为匿名对象不是同一个对象
        synchronized(d) {
            System.out.print("学");
            System.out.print("生");
            System.out.print("\r\n");
        }

    }

}


class Demo {

}
