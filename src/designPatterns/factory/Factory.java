package designPatterns.factory;

interface Product{
    void displayInfo();
}

class ConcreteProductA implements Product{
    @Override
    public void displayInfo() {
        System.out.println("This is Concrete Product A");
    }
}

class ConcreteProductB implements Product{
    @Override
    public void displayInfo() {
        System.out.println("This is Concrete Product B");
    }
}

interface ProductFactory {
    Product createProduct();
}

class ConcreteProductAFactory implements ProductFactory{
    @Override
    public Product createProduct() {
        return new ConcreteProductA();
    }
}

class ConcreteProductBFactory implements ProductFactory{
    @Override
    public Product createProduct() {
        return new ConcreteProductB();
    }
}


public class Factory {
    public static void main(String[] args) {
        ProductFactory factoryOne = new ConcreteProductAFactory();
        Product product = factoryOne.createProduct();
        product.displayInfo();

        ProductFactory factoryTwo = new ConcreteProductBFactory();
        Product productB = factoryTwo.createProduct();
        productB.displayInfo();
    }
}
