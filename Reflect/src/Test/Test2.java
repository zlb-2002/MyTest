package Test;

import bean.Person;

public class Test2 {

    public static void main(String[] args) throws Exception {
        Person p = new Person("张三",23);

        System.out.println(p);

        Tool t = new Tool();
        t.setProperty(p,"张三","李四");
    }

}
