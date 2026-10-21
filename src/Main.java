import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //创建String集合
        ArrayList<String> list = new ArrayList<>();

        //添加元素
        list.add("zs");
        list.add("ls");

        //获取元素
        String first = list.get(0);

        //修改元素
        list.set(0,"ww");

        //删除元素
        list.remove(1);

        int size = list.size();
        System.out.println(size);

        //判断是否包含元素
        boolean hasZS = list.contains("zs");
        System.out.println(hasZS);

        //两种遍历，一种普通循环，推荐增强for循环
        for (String s : list){
            System.out.println(s);
        }

        //练习通讯录管理。
        System.out.println("通讯录管理");
        ArrayList<String> addressBook = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        boolean runnning = true;
        while(runnning){
            System.out.println("请输入操作选项：1.添加联系人 2.删除联系人 3.修改联系人 4.查询联系人 5.显示联系人 6.退出");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    System.out.println("请输入联系人名称：");
                    String name = scanner.next();
                    addressBook.add(name);
                    System.out.println("添加成功");
                    break;
                case 2:
                    System.out.println("请输入要删除的联系人名称：");
                    String removeName = scanner.next();
                    if (addressBook.contains(removeName)){
                        addressBook.remove(removeName);
                        System.out.println("删除成功");
                    } else {
                        System.out.println("联系人不存在");
                    }
                    break;
                case 3:
                    System.out.println("请输入要删除联系人名称：");
                    String oldName = scanner.next();
                    int index = addressBook.indexOf(oldName);
                    if (index != -1){
                        System.out.println("请输入新的联系人名称：");
                        String newName = scanner.next();
                        addressBook.set(index, newName);
                        System.out.println("修改成功");
                    }else {
                        System.out.println("联系人不存在");
                    }
                    break;
                case 4:
                    System.out.println("请输入要查询的联系人名称：");
                    String queryName = scanner.next();
                    if (addressBook.contains(queryName)){
                        System.out.println("联系人存在");
                    }else {
                        System.out.println("联系人不存在");
                    }
                    break;
                case 5:
                    System.out.println("显示联系人");
                    for (String address :addressBook){
                        System.out.println(address);
                    }
                    break;
                case 6:
                    System.out.println("退出系统");
                    runnning = false;
                    break;
                default:
                    System.out.println("输入错误");
                    break;


            }


        }
        System.out.println("程序已经安全退出！");
        scanner.close();

    }

}