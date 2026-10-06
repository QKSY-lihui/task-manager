import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //todo 条件语句if学习
        /*int score = 85;
        if (score>=90){
            System.out.println("优秀");
        } else if (score>=80) {
            System.out.println("良好");
        } else if (score>=60) {
            System.out.println("及格");
        }else {
            System.out.println("不及格");
        }*/

        //todo 条件switch语句
        /*int day =3;
        switch(day){
            case 1:
                System.out.println("星期一");
                break;
            case 2:
                System.out.println("星期二");
                break;
            case 3:
                System.out.println("星期三");
                break;
            default:
                System.out.println("其他");
                break;
        }*/

        //独立练习：成绩等级判断
        /*System.out.println("成绩等级判断");
        Scanner scanner = new Scanner(System.in);

        System.out.println("输入成绩：");
        int score = scanner.nextInt();
        if (100>=score && score>=90) {
            System.out.println("优秀");
        }else if (score>=80 && score<90) {
            System.out.println("良好");
        }if (score>=60 && score<80) {
            System.out.println("及格");
        }else if (score<60 &&score>=0){
            System.out.println("不及格");
        } else {
            System.out.println("输入分数不合法！");
        }
*/
        //todo switch语句练习

        System.out.println("switch语句练习");
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入成绩：");
        int score = scanner.nextInt();

        if (score> 100 || score < 0){
            System.out.println("输入分数不合法！");
        }else {
            switch(score/10){
                case 10:
                case 9:
                    System.out.println("优秀");
                    break;
                case 8:
                    System.out.println("良好");
                    break;
                case 7:
                    System.out.println("及格");
                    break;
                case 6:
                    System.out.println("及格");
                    break;
                case 5:
                case 4:
                case 3:
                case 2:
                case 1:
                case 0:
                    System.out.println("不及格");
                    break;

        }


        }


    }

}