package Foctory_Method;

public class CatFactory implements Factory {
    @Override
    public Animal craeteAnimal() {
        return new Cat();
    }
}
