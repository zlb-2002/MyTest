package reflect;

import java.io.BufferedReader;
import java.io.FileReader;


public class Demo2_Reflect {

    public static void main(String[] args) throws Exception {
        /*
        new Juicer().run(new Apple());
        new Juicer().run(new Apple());*/
        BufferedReader br = new BufferedReader(new FileReader("config.txt"));
        Class clazz = Class.forName(br.readLine());
        Fruit f = (Fruit) clazz.newInstance();      //��������ָ���������
        Juicer j = new Juicer();
        j.run(f);
    }

}

interface Fruit {
    public void squeeze();
}

class Apple implements Fruit {
    public void squeeze() {
        System.out.println("ե��һ��ƻ��֭��");
    }

}

class Orange implements Fruit {
    public void squeeze() {
        System.out.println("ե��һ������֭��");
    }
}

class Juicer {

    public void run (Fruit f) {
        f.squeeze();
    }
}

