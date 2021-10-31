package Text1;

public class Text2 {



    public static void main(String[] args) {
        MyRunnable my = new MyRunnable();
        new Thread(new Runnable() {
            @Override
            public void run() {
                my.run();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                my.stop();
            }
        }).start();
    }

}

