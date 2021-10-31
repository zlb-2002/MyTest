package Thread3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo5_Executors {

    /*
    线程池的概述
        程序启动一个线程的成本是比较高的，因为它涉及到要与操作系统进行交互，而使用线程池可以很好的提高性能，尤其是当程序中要创建大量的生存
        周期很短的线程时，更应该考虑使用线程池，线程池里的每一个线程代码结束后，并不会死亡，而是再次回到线程池中成为空闲状态，等待下一个对
        象来使用，在JDK5之前，我们必须动手实现自己的线程池，从JDK5开始，Java内置支持线程池
    内置线程池的使用概述：
        JDK新增了一个Executors工厂类来产生线程池，有如下几个方法：
            public static ExecutorService newFixedThreadPool(int nThreads)
            public static ExecutorService newSingleThreadExecutor()
     */
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(2);
        pool.submit(new MyRunnable());      //将线程放进池子里，并让其执行
        pool.submit(new MyRunnable());

        pool.shutdown();            //关闭线程池
    }

}


