public class Student {
    //属性
    private String name;
    private int id;
    private int score;

    public Student() {
    }
    public Student(String name, int id, int score) {
        this.name = name;
        this.id = id;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //方法
    public void printInfo(){
        System.out.println("姓名：" + name + ", 学号：" + id + ", 成绩：" + score);
    }
}
