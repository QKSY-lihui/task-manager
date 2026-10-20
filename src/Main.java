import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       Animal[] animals = new Animal[3];
       animals[0] = new Dog("旺财");
       animals[1] = new Cat("咪咪");
       animals[2] = new Animal("小动物");

       for (Animal animal : animals){
           animal.makeSound();//同一行代码。不同对象有不同行为，这就是多态
       }

       Shape[] shapes = new Shape[3];
       shapes[0] = new Circle(5);
       shapes[1] = new Rectangle(4, 6);
       shapes[2] = new Shape();
       for (Shape shape : shapes){
           shape.area();//同一行代码。不同对象有不同行为，这就是多态
       }



    }

}