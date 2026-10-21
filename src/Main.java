import java.util.*;

public class Main {
    public static void main(String[] args) {

        //创建一个 HashMap，键是 String（名字），值是 String（电话）
        HashMap<String, String> map = new HashMap<>();

        //添加元素，更新元素（key唯一，value可重复），若key已存在，覆盖value值
        map.put("zs", "13950006000");
        map.put("ls", "13850006000");

        map.put("zs", "13960006000");
        //获取元素,获取不存在的 Key，会返回 null
        String first = map.get("zs");
        System.out.println("张三号码："+first);



        //删除元素
        map.remove("ls");

        int size = map.size();
        System.out.println(size);

        //判断是否包含元素
        boolean hasZS = map.containsKey("ls");
        System.out.println(hasZS);

        //两种遍历，一种普通循环，推荐增强for循环
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        //练习通讯录管理。
        System.out.println("通讯录管理");
        HashMap<String, String> addressBook = new HashMap<>();

        Scanner scanner = new Scanner(System.in);

        boolean runnning = true;
        while(runnning){
            System.out.println("请输入操作选项：1.添加联系人 2.删除联系人 3.修改联系人 4.查询联系人 5.显示联系人 6.退出");
            String input = scanner.nextLine();
            int option = -1;
            //输入校验，防止用户非法输入，使用 try-catch 捕获异常
            try {
                option = Integer.parseInt(input);
            }catch (NumberFormatException e){
                System.out.println("输入错误，请输入数字");
                continue;
            }
            switch (option) {
                case 1:
                    System.out.println("请输入联系人名称：");
                    String name = scanner.next();
                    System.out.println("请输入联系人电话：");
                    String phone = scanner.next();
                    addressBook.put(name, phone);
                    System.out.println("添加成功");
                    break;
                case 2:
                    System.out.println("请输入要删除的联系人名称：");
                    String removeName = scanner.next();
                    if (addressBook.containsKey(removeName)){
                        addressBook.remove(removeName);
                        System.out.println("删除成功");
                    } else {
                        System.out.println("联系人不存在");
                    }
                    break;
                case 3:
                    System.out.println("请输入要修改联系人名称：");
                    String oldName = scanner.next();
                    if (addressBook.containsKey(oldName)){
                        System.out.println("请输入新的联系人号码：");
                        String newPhone = scanner.next();
                        addressBook.put(oldName, newPhone);
                        System.out.println("修改成功");
                    }else {
                        System.out.println("联系人不存在");
                    }
                    break;
                case 4:
                    System.out.println("请输入要查询的联系人名称：");
                    String queryName = scanner.next();
                    if (addressBook.containsKey(queryName)){
                        System.out.println("该联系人存在,且号码为"+addressBook.get(queryName));
                    }else {
                        System.out.println("该联系人不存在");
                    }
                    break;
                case 5:
                    System.out.println("显示联系人");
                    for (Map.Entry<String, String> entry : addressBook.entrySet()) {
                        System.out.println(entry.getKey() + ": " + entry.getValue());
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