import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("学生成绩管理系统");
        Scanner scanner = new Scanner(System.in);
        int[] scores = inputScores(scanner);
        printScore(scores);
        statistics(scores);
        System.out.println("请输入要查找的成绩：");
        int targetScore = scanner.nextInt();
        int index = find(scores, targetScore);
        if (index != -1){
            System.out.println("找到成绩" + targetScore + "，索引是" + index);
        }else {
            System.out.println("未找到成绩" + targetScore);
        }
        sortScores(scores);
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
    //统计
    public static void statistics(int[] scores){
        int max = scores[0];
        int min = scores[0];
        int sum = 0;
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] > max) {
                max = scores[i];
            }
            if (scores[i] < min) {
                min = scores[i];
            }
            sum += scores[i];
        }
        double average = (double)sum / scores.length;
        System.out.println("最高分是" + max);
        System.out.println("最低分是" + min);
        System.out.println("平均分是" + average);
    }
    //查找
    public static int  find(int[] scores,int targetScore){
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == targetScore){
                return i;
            }
        }
        return -1;
    }
    //排序：升序
    public static void sortScores(int[] scores){
        int temp =0;
        for (int i = 0; i < scores.length - 1; i++) {
            for (int j = 0; j < scores.length -1 - i; j++) {
                if (scores[j]>scores[j+1]){
                    temp = scores[j];
                    scores[j] = scores[j+1];
                    scores[j+1] =temp;
                }
            }
        }
        //Arrays.sort(scores);
        System.out.println("排序后的成绩是" + Arrays.toString(scores));
    }

}