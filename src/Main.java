import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Student[] students = inputScores(scanner);
        printScores(students);
        printStatistics(students);

        System.out.println("请输入要查找的成绩：");
        int target = scanner.nextInt();
        int index = findScore(students, target);
        if (index != -1){
            System.out.println("找到该成绩学生为：" + students[index].getName() + " " + students[index].getId());
        }else {
            System.out.println("未找到该成绩");
        }

        printSorted(students);
        System.out.println("排序后成绩：");
        printScores(students);
        scanner.close();

    }
    // 录入成绩
    public static Student[] inputScores(Scanner scanner) {
        System.out.print("请输入学生人数：");
        int count = scanner.nextInt();
        //int[] scores = new int[count];
        Student[] students = new Student[count];
        for (int i = 0; i < count; i++) {
            System.out.println("请输入第 " + (i + 1) + " 个学生的信息：");
            System.out.println("姓名：");
            String name = scanner.next();
            System.out.println("学号：");
            int id = scanner.nextInt();
            System.out.println("分数：");
            int score = scanner.nextInt();
            students[i] = new Student(name, id, score);

        }
        return students;
    }

    // 打印成绩
    public static void printScores(Student[] students) {
        for (Student student : students){
            System.out.println(student.getName() + " " + student.getId() + " " + student.getScore());
        }


    }

    // 统计：总分、平均分、最高分、最低分
    public static void printStatistics(Student[] students) {
        int sum =0;
        Student max = students[0];
        Student min = students[0];

        for (int i = 0; i < students.length; i++) {
            sum += students[i].getScore();
            if(students[i].getScore() > max.getScore()){
                max = students[i];
            }
            if (min.getScore() > students[i].getScore()){
                min = students[i];
            }
        }
        double average = (double)sum/students.length;
        System.out.println("总分：" + sum);
        System.out.println("平均分：" + average);
        System.out.println("最高分：" + max.getScore());
        System.out.println("最低分：" + min.getScore());
    }

    // 查找：输入分数，返回索引，找不到返回 -1
    public static int findScore(Student[] students, int target) {
        for (int i = 0; i < students.length; i++) {
            if (students[i].getScore() == target) {
                return i;
            }
        }
        return -1;
    }

    // 排序：升序输出
    public static void printSorted(Student[] students) {
        for (int i = 0; i < students.length - 1; i++) {
            for (int j = 0; j < students.length - 1 - i; j++){
                if (students[j].getScore() > students[j + 1].getScore()) {
                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }
        //Arrays.sort(scores);
    }

}