import java.util.LinkedList;

class Fruit{
    private double weight;
    public Fruit(double weight) {
        this.weight = weight;
    }
}
class Apple extends Fruit{
    public Apple(double weight) {
        super(weight);
    }
}
class Pear extends Fruit{

    public Pear(double weight) {

        super(weight);
    }
}
class MyStack<T> {
    private LinkedList<T> List = new LinkedList<>();

    public void pop () {
        List.removeFirst();
    }

    public void push (T t) {
        List.addFirst(t);
    }



}
//������

public class Test {

    public static void main(String[] args) {

        Fruit fruit = new Fruit(5);

        Apple apple = new Apple(5);

        Pear pear = new Pear(6);
        //stack��MyStack��Ķ��󣬲���������������
        MyStack stack = new MyStack();
        stack.push(fruit);
        stack.push(apple);
        stack.push(pear);
    }
}