import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*for (int i = 0; i < 5; i++) {
            System.out.println("循环第"+i+"次！");
        }*/

        /*int i = 1;
        while (i<=5) {
            System.out.println("循环第"+i+"次！");
            i++;
        }*/

        System.out.println("猜数字游戏");

        // 生成1~100的随机数
        int random = (int) (Math.random() * 100) + 1;

        Scanner scanner = new Scanner(System.in);
        int number;
        while (true) {
            System.out.println("请输入整数猜数字，范围在1~100。");
            number = scanner.nextInt();
            if (number > 100 || number < 1) {
                System.out.println("输入的数字超出范围！");
                continue;
            }
            if (number == random) {
                System.out.println("恭喜你，猜对了！");
                break;
            } else if (number > random ) {
                System.out.println("太大了！");
            } else {
                System.out.println("太小了！");
            }
        }

        /*System.out.println("请输入整数猜数字，范围在1~100。");
        int number = scanner.nextInt();

        while (number != random){
            if (number > random) {
                System.out.println("太大了！");
            } else {
                System.out.println("太小了！");
            }
            System.out.println("请输入整数猜数字，范围在1~100。");
            number = scanner.nextInt();
        }
            System.out.println("恭喜你，猜对了！");*/
    }


}