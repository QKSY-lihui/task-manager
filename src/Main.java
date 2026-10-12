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
        book.setName("《Java从入门到精通》");
        book.setAuthor("张三");
        book.setPrice(80);
        book.print();

        Book book1 = new Book("《Java从入门到精通二》", "李四", 90);
        book1.setPrice(-1);
        System.out.println("书的总数为：" + Book.getCount());


        Car car = new Car();
        car.setBrand("特斯拉");
        car.setColor("红色");
        car.setPrice(100000);
        car.print();

    }

}