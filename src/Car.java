public class Car {
    //品牌
    private String brand;
    //颜色
    private String color;
    //价格
    private double price;

    //构造方法
    public Car() {
    }
    public Car(String brand, String color, double price) {
        this.brand = brand;
        this.color = color;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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

    //方法
    public void print() {
        System.out.println("品牌：" + brand + ", 颜色：" + color + ", 价格：" + price);
    }
}
