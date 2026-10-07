import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

       /*//闰年判断
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入年份：");
        int year = scanner.nextInt();
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            System.out.println(year + "是闰年");
        } else {
            System.out.println(year + "不是闰年");
        }*/

        //寻找1~100能被3整除的数
        int count = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0){
                System.out.print(i + " ");
                count++;
                if (count % 5 ==0) {
                    System.out.println();
                }
            }
        }
    }


}