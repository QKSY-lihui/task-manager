public class Book {
    String name;
    String author;
    double price;

    //构造方法
    //无参构造方法
    public Book() {
    }
    //有参构造方法
    public Book(String name, String author, double price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }
    //打印
    public void print() {
        System.out.println("书名：" + name + ", 作者：" + author + ", 价格：" + price);
    }
}
