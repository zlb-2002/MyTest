package otherIO;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Demo5_ObiectInputStream {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //Demo1();
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("e.txt"));
        ArrayList<Person> list = (ArrayList<Person>) ois.readObject();
        for (Person person : list) {
            System.out.println(person);
        }
        ois.close();
    }

    private static void Demo1() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("e.txt"));

        Person p1 = (Person)ois.readObject();
        Person p2 = (Person)ois.readObject();

        System.out.println(p1);
        System.out.println(p2);
        ois.close();
    }


}
