public class Book {
    private static int count = 0;
    private String name;
    private String author;
    private double price;

     //构造方法
    //无参构造方法
    public Book() {
        count++;
    }
    //有参构造方法
    public Book(String name, String author, double price) {
        this.name = name;
        this.author = author;
        this.price = price;
        count++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0) {
            System.out.println("价格不能为负数");
            return;
        }
        this.price = price;
    }

    public static int getCount() {
        return count;
    }

    //打印
    public void print() {
        System.out.println("书名：" + name + ", 作者：" + author + ", 价格：" + price);
    }
}
