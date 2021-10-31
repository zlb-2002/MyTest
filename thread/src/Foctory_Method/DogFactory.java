package Foctory_Method;

public class DogFactory implements Factory {
    @Override
    public Animal craeteAnimal() {
        return new Dog();
    }
}
