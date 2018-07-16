/**
 * 工厂设计模式
 */
public class TestFactory {
    
    public static void main(String[] args) {
        Fruit f = FruitFactory.getInstance(args[0]);
        if(f!=null) {
            f.eat();
        } else {
            System.out.println("The fruit is not exists...");
        }
    }

}

interface Fruit {
    public void eat();
}

class Apple implements Fruit {
    @Override
    public void eat() {
        System.out.println("eat apple...");
    }
}

class Pear implements Fruit {
    @Override
    public void eat() {
        System.out.println("eat pear...");
    }
}

class FruitFactory {
    public static Fruit getInstance(String name) {
        switch(name) {
            case "apple":
                return new Apple();
            case "pear":
                return new Pear();
            default:   
                return null;
        }
    }
}