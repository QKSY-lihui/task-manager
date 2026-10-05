import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //照着案例，练习控制台输入输出
        /*Scanner scanner = new Scanner(System.in);

        System.out.println("请输入你的名字：");
        String name = scanner.nextLine();

        System.out.println("请输入你的年龄：");
        int age = scanner.nextInt();

        System.out.println("你好，"+name+"。你今年"+age+"岁。");

        scanner.close();
        */
        //不看案例，独立编写商品结算小程序
        Scanner scanner1 = new Scanner(System.in);

        System.out.println("商品结算小程序");
        System.out.println("请输入商品价格：");
        double price = scanner1.nextDouble();

        System.out.println("请输入商品数量：");
        int number = scanner1.nextInt();

        double total = price * number;
        if (total>100){total=total*0.9;}
        System.out.println("商品总价为："+total);

        scanner1.close();

    }


}