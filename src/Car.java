public class Car {
    //品牌
    String brand;
    //颜色
    String color;
    //价格
    double price;

    //构造方法
    public Car() {
    }
    public Car(String brand, String color, double price) {
        this.brand = brand;
        this.color = color;
        this.price = price;
    }
    //方法
    public void print() {
        System.out.println("品牌：" + brand + ", 颜色：" + color + ", 价格：" + price);
    }
}
