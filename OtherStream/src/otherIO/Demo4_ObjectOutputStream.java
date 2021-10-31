package otherIO;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Demo4_ObjectOutputStream {

    public static void main(String[] args) throws IOException {
        //Demo1();
        Person p1 = new Person("����",23);
        Person p2 = new Person("����",24);
        Person p3 = new Person("����",25);
        Person p4 = new Person("����",26);

        ArrayList<Person> list = new ArrayList<>();
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("e.txt"));
        oos.writeObject(list);
        oos.close();
    }

    private static void Demo1() throws IOException {
        Person p1 = new Person("����",23);
        Person p2 = new Person("����",24);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("e.txt"));
        oos.writeObject(p1);
        oos.writeObject(p2);

        oos.close();
    }

}
