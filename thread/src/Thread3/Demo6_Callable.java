package Thread3;

import java.util.concurrent.*;

public class Demo6_Callable {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(2);
        Future<Integer> f1 = pool.submit(new MyCallable(100));      //将线程放进池子里，并让其执行
        Future<Integer> f2 = pool.submit(new MyCallable(50));

        System.out.println(f1.get());
        System.out.println(f2.get());

        pool.shutdown();
    }

}

class MyCallable implements Callable<Integer> {

    private int num;
    public MyCallable(int num) {
        this.num = num;
    }

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 1;i <= num;i++) {
            sum = sum + i;
        }

        return sum;
    }
}
