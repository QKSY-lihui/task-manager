import java.util.*;

public class Main {
    public static void main(String[] args) {


        //创建一个 HashSet，元素是 String（水果名称）
        HashSet<String> set = new HashSet<>();
        //添加元素，不重复
        set.add("苹果");
        set.add("香蕉");
        boolean test = set.add("苹果");//重复元素，不会被添加
        System.out.println(test);

        System.out.println(set.size()); // 输出: 2
        System.out.println(set.contains("苹果")); // 输出: true

        //删除元素
        set.remove("香蕉");

        //两种遍历，一种普通循环，推荐增强for循环
        for (String fruit : set){
           System.out.println(fruit);
        }


        //练习抽奖系统
        ArrayList<String> names = new ArrayList<>();
        names.add("张一");
        names.add("张二");
        names.add("张三");
        names.add("李四");
        names.add("王五");
        names.add("赵六");
        names.add("孙七");
        names.add("周八");
        names.add("吴九");
        names.add("郑十");
        int winnerCount = 6;
        HashSet<String> winners = new HashSet<>();
        while (winners.size() < winnerCount) {
            int randomIndex = (int)(Math.random()*names.size());
            String name = names.get(randomIndex);
            if (winners.add(name)){
                System.out.println(name + " 中奖了！");
            }
        }
    }

}