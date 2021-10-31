package Text1;

public class MyRunnable implements Runnable
{
    private boolean active;
    public void run()
    {
        active = true;
        while (active) // 第一行
        {
            System.out.println(1);
        }
    }
    public void stop()
    {
        active = false; // 第二行
    }
}