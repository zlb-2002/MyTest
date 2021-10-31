package reflect;

import bean.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class Demo4_Field {

    public static void main(String[] args) throws Exception {
        Class clazz = Class.forName("bean.Person");
        Constructor c = clazz.getConstructor(String.class,int.class);
        Person p = (Person) c.newInstance("����",23);

        /*Field f = clazz.getField("name");      //��ȡ�����ֶ�
        f.set(p,"����");*/                        //ͨ���вι��촴������

        Field f = clazz.getDeclaredField("name");       //���������ȡ�ֶ�
        f.setAccessible(true);                                //ȥ��˽��Ȩ��
        f.set(p,"����");
        System.out.println(p);
    }

}
