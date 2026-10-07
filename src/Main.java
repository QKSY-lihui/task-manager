import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        playGame();
    }

    //生成随机数
    public static int generateRandomNumber() {
        return (int) (Math.random() * 100) + 1;
    }

    //获取猜测数字
    public static int getGuessNumber(Scanner scanner) {
        System.out.print("请输入猜测的数字：");
        return scanner.nextInt();
    }

    //判断猜测数字
    public static boolean checkNumber(int randomNumber, int guessNumber) {
        if (guessNumber > randomNumber) {
            System.out.println("太大了！");
        } else if (guessNumber < randomNumber) {
            System.out.println("太小了！");
        } else {
            System.out.println("恭喜你，猜对了！");
            return true;
        }
        return false;
    }

    //游戏循环体
    public static void playGame() {
        Scanner scanner = new Scanner(System.in);
        int randomNumber = generateRandomNumber();
        while (true) {
            int guessNumber = getGuessNumber(scanner);
            if (checkNumber(randomNumber, guessNumber)){
                break;
            }
        }

    }

}