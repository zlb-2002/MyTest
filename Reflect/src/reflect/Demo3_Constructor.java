package reflect;

import bean.Person;

import java.lang.reflect.Constructor;

public class Demo3_Constructor {

    public static void main(String[] args) throws Exception {
        Class clazz = Class.forName("bean.Person");
/*      Person p = (Person) clazz.newInstance();
        System.out.println(p);*/            //通过无参构造创建对象
        Constructor c = clazz.getConstructor(String.class,int.class);     //获取有参构造
        Person p = (Person) c.newInstance("张三",23);             //通过有参构造创建对象
        System.out.println(p);
    }

}
