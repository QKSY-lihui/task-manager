import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //二维数组
        //声明直接赋值
        int[][] array = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        /*
        //先声明再赋值
        int[][] array1 = new int[3][3];
        array1[0][1] = 1;
        array1[0][2] = 2;*/

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();

        }

        //二维数组统计
        int[][] array2 = {
                {1, 3, 2, 9},
                {5, 7, 6, 8},
                {9, 10, 11, 12}
        };
        for (int i = 0; i < array2.length; i++) {
            for (int j = 0; j < array2[i].length; j++) {
                System.out.print(array2[i][j] + " ");
            }
            System.out.println();
        }
        //总和
        int sum =0;
        for (int i = 0; i < array2.length; i++) {
            for (int j = 0; j < array2[i].length; j++) {
                sum += array2[i][j];
            }
        }
        System.out.println("总和为: " + sum);
        //平均值
        double average = (double) sum / (array2.length * array2[0].length);
        System.out.println("平均值为: " + average);
        //最大值
        int max =array2[0][0];
        for (int i = 0; i < array2.length; i++) {
            for (int j = 0; j < array2[i].length; j++) {
                if (array2[i][j] > max){
                    max = array2[i][j];
                }
            }

        }
        System.out.println("最大值为: " + max);
        //最小值，同理

        //二维数组排序
        Arrays.sort(array2, (a, b) -> a[0] - b[0]); // 按第一列排序
        System.out.println(Arrays.deepToString(array2));
        Arrays.sort(array2, (a, b) -> a[1] - b[1]); // 按第二列排序
        System.out.println(Arrays.deepToString(array2));
        Arrays.sort(array2, (a, b) -> a[2] - b[2]); // 按第三列排序
        System.out.println(Arrays.deepToString(array2));

        //5*5乘法表
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 5; j++) {
                System.out.print(i*j+"\t");
            }
            System.out.println();

        }
    }

}