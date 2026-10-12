import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("学生成绩管理系统");
        Scanner scanner = new Scanner(System.in);
        int[] scores = inputScores(scanner);
        printScore(scores);
        scanner.close();
    }
    //输入成绩
    public static int[] inputScores(Scanner scanner){
        System.out.println("请输入学生人数");
        int number = scanner.nextInt();
        int[] scores = new int[number];
        for (int i = 0; i < scores.length; i++) {
            System.out.println("请输入第" + (i + 1) + "个学生的成绩");
            scores[i] = scanner.nextInt();
        }
        return scores;
    }
    //遍历打印成绩
    public static void printScore(int[] scores){
        for (int i = 0; i < scores.length; i++) {
            System.out.println("第" + (i + 1) + "个学生的成绩是" + scores[i]);
        }
    }

}