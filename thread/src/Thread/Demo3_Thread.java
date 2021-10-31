package Thread;

public class Demo3_Thread {

    /*
    继承Thread：由于子类重写了Thread类中的run()方法，当调用start()时，直接找子类的run()方法
    实现Runnable：构造函数中传入了Runnable的引用，成员变量记住了它，start()调用run()方法时内部判断成员变量Runnable的引用是否为空，
    不为空编译时看的是Runnable的run(),运行时执行的是子类的run()方法

    继承Thread
        好处是：可以直接使用Thread类中的方法，代码简单
        弊端是：如果已经有了子类就不能使用这种方法

    实现Runnable接口
        好处是：即使自己定义的线程类有了父类也没有关系，因为有了父类也可以实现接口，而且接口时可以多实现的
        弊端是：不能直接使用Thread中的方法，需要先获取到线程对象后，才能得到Thread的方法，代码复杂
     */
    public static void main(String[] args) {
        MyRunnable mr = new MyRunnable();       //4.创建Runnable的子类对象
        //Runnable target = mr;             //父类引用指向子类对象

        Thread t = new Thread(mr);              //5.将其当作参数传递给Thread的构造函数
        t.start();                              //6.开启线程
        for (int i = 0;i < 1000;i++ ) {
            System.out.println("bb");
        }
    }
}

class MyRunnable implements Runnable {      //1.定义一个类实现一个Runnable

    @Override                               //2.重写run方法
    public void run() {
        for (int i = 0;i < 1000;i++) {      //3.要运行的代码
            System.out.println("aaaaa");
        }
    }
}
