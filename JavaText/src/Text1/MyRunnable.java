package Text1;

public class MyRunnable implements Runnable
{
    private boolean active;
    public void run()
    {
        active = true;
        while (active) // ��һ��
        {
            System.out.println(1);
        }
    }
    public void stop()
    {
        active = false; // �ڶ���
    }
}