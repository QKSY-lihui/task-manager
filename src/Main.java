import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //声明
        int[] scores = new int[5];
        //赋值
        scores[0] = 60;
        scores[1] = 75;
        scores[2] = 55;
        scores[3] = 90;
        scores[4] = 85;
        //遍历输出
        for (int i = 0; i < scores.length; i++) {
            System.out.println("Score " + i + ": " + scores[i]);
        }


        //自定义算法、Arrays工具类和stream流

        //排序,升序
        Arrays.sort(scores);
        //降序
        for (int i = scores.length - 1; i >= 0; i--) {
            System.out.println("Score " + i + ": " + scores[i]);
        }

        //和
        int sum1 = 0;
        for (int score : scores) {
            sum1 += score;
        }
        System.out.println("Sum1: " + sum1);

        int sum2 = Arrays.stream(scores).sum();
        System.out.println("Sum2: " + sum2);

        //平均值
        double average1 = sum1 / scores.length;
        double average2 = Arrays.stream(scores).average().orElse(0.0);
        System.out.println("Average1: " + average1);
        System.out.println("Average2: " + average2);
        //最大值
        int max1 = scores[0];
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] > max1) {
                max1 = scores[i];
            }
        }
        System.out.println("Max1: " + max1);
        //最小值
        int min1 = scores[0];
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] < min1) {
                min1 = scores[i];
            }
        }
        System.out.println("Min1: " + min1);
        //数组长度
        System.out.println("Array length: " + scores.length);

        //数组转字符串
        String scoresString = Arrays.toString(scores);
        System.out.println("Array as string: " + scoresString);
        //数组复制
        int[] scoresCopy = Arrays.copyOf(scores, scores.length);
        System.out.println("Array copy: " + Arrays.toString(scoresCopy));
        //数组比较
        boolean areEqual = Arrays.equals(scores, scoresCopy);
        System.out.println("Arrays are equal: " + areEqual);
        //数组填充
        Arrays.fill(scores, 0);
        System.out.println("Array after fill: " + Arrays.toString(scores));

    }

}