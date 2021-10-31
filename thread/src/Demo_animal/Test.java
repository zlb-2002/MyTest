package Demo_animal;

public class Test {

    /*
    简单工厂模式概述：
        又叫静态工厂方法模式，它定义一个具体的工厂负责创建一些类的实例
    优点：
        客户端不需要在负责对象的创建，从而明确了各个类的职责
    缺点:
        这个静态工厂负责所有对象的创建，如果有新的对象需要添加，或者某些对象的创建方式不同，就需要不断的修改工厂类，不利于后期的维护

    工厂方法模式的概述：
        工厂方法模式中抽象工厂类负责定义创建对象的接口，具体对象的创建工作有继承抽象工厂的具体类实现
    优点：
        客户端不需要在负责对象的创建，从而明确了各个类的职责，只需要有新的对象添加，只需要增加一个具体类和具体的工厂类即可，不影响已
        有的代码，后期维护容易，增强了系统的扩展性
    缺点：
        需要额外的编写代码，增加了工作量
     */
    public static void main(String[] args) {
/*        Dog d = AnimalFactory.createDog();

        Cat c = AnimalFactory.createCat();

        System.out.println(d);
        System.out.println(c);*/

        Dog d = (Dog)AnimalFactory.createAnlmal("dog");
        d.eat();

        Cat c = (Cat)AnimalFactory.createAnlmal("cat");
        c.eat();
    }

}
