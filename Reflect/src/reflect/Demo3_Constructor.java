package reflect;

import bean.Person;

import java.lang.reflect.Constructor;

public class Demo3_Constructor {

    public static void main(String[] args) throws Exception {
        Class clazz = Class.forName("bean.Person");
/*      Person p = (Person) clazz.newInstance();
        System.out.println(p);*/            //ͨ���޲ι��촴������
        Constructor c = clazz.getConstructor(String.class,int.class);     //��ȡ�вι���
        Person p = (Person) c.newInstance("����",23);             //ͨ���вι��촴������
        System.out.println(p);
    }

}
