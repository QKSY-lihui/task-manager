import java.util.*;

public class Main {
    public static void main(String[] args) {
        //练习通讯录管理。
        System.out.println("通讯录管理");
        HashMap<String, User> addressBook = new HashMap<>();

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
                    User newUser = new User();
                    System.out.println("请输入联系人名称：");
                    String name = scanner.nextLine();
                    newUser.setName(name);
                    System.out.println("请输入联系人电话：");
                    String phone = scanner.nextLine();
                    newUser.setPhone(phone);
                    System.out.println("请输入邮箱：");
                    String email = scanner.nextLine();
                    newUser.setEmail(email);
                    addressBook.put(name, newUser);
                    System.out.println("添加成功");
                    break;
                case 2:
                    System.out.println("请输入要删除的联系人名称：");
                    String removeName = scanner.nextLine();
                    if (addressBook.containsKey(removeName)){
                        addressBook.remove(removeName);
                        System.out.println("删除成功");
                    } else {
                        System.out.println("联系人不存在");
                    }
                    break;
                case 3:
                    System.out.println("请输入要修改联系人名称：");
                    String oldName = scanner.nextLine();
                    if (addressBook.containsKey(oldName)){
                        User user = addressBook.get(oldName);
                        System.out.println("请输入新的联系人号码：");
                        user.setPhone(scanner.nextLine());
                        System.out.println("请输入新的邮箱：");
                        user.setEmail(scanner.nextLine());
                        System.out.println("修改成功");
                    }else {
                        System.out.println("联系人不存在");
                    }
                    break;
                case 4:
                    System.out.println("请输入要查询的联系人名称：");
                    String queryName = scanner.nextLine();
                    if (addressBook.containsKey(queryName)){
                        System.out.println("该联系人存在,且信息为"+addressBook.get(queryName).toString());
                    }else {
                        System.out.println("该联系人不存在");
                    }
                    break;
                case 5:
                    System.out.println("显示联系人");
                    for (Map.Entry<String, User> entry : addressBook.entrySet()) {
                        System.out.println(entry.getKey() + ": " + entry.getValue().toString());
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