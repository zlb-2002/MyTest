package syn;

public class Demo2_Synchronized {

    public static void main(String[] args) {
        final Printer2 p = new Printer2();

        new Thread() {
            @Override
            public void run() {
                while(true) {
                    p.print1();
                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                while(true) {
                    p.print2();
                }
            }
        }.start();
    }

}

class Printer2 {
    Demo d = new Demo();
    //非静态方法的锁机制可以为this
    //静态方法为字节码文件
    public synchronized void print1() {
        //同步代码块，锁机制，锁对象是任意的
            System.out.print("程");
            System.out.print("序");
            System.out.print("员");
            System.out.print("\r\n");

    }

    public static void print2() {
        //锁对象不能用匿名对象，因为匿名对象不是同一个对象
        synchronized(Printer2.class) {
            System.out.print("学");
            System.out.print("生");
            System.out.print("\r\n");
        }

    }

}


