import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Student student = new Student();
        student.name = "张三";
        student.id = 123456;
        student.score = 80;
        student.printInfo();

        Book book = new Book();
        book.name = "《Java从入门到精通》";
        book.author = "张三";
        book.price = 80;
        book.print();

        Car car = new Car();
        car.brand = "特斯拉";
        car.color = "红色";
        car.price = 100000;
        car.print();

    }

}