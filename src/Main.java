import java.util.*;

public class Main {
    public static void main(String[] args) {
        //练习通讯录管理。
        System.out.println("通讯录管理");
        //加载数据
        HashMap<String, User> addressBook = (HashMap<String, User>) ContactStorage.load();

        boolean runnning = true;
        while(runnning){
            String prompt = "请输入操作选项：1.添加联系人 2.删除联系人 3.修改联系人 4.查询联系人 5.显示联系人 6.退出";
            int option = ConsoleInputUtil.readInt(prompt, 1, 6);

            switch (option) {
                case 1:
                    String name = ConsoleInputUtil.readNonEmptyString("请输入联系人名称：");
                    String phone = ConsoleInputUtil.readNonEmptyString("请输入联系人电话：");
                    String email = ConsoleInputUtil.readNonEmptyString("请输入邮箱：");
                    User newUser = new User(name, phone, email);
                    addressBook.put(name, newUser);
                    ContactStorage.save(addressBook);
                    System.out.println("添加成功");
                    break;
                case 2:
                    String removeName = ConsoleInputUtil.readNonEmptyString("请输入要删除的联系人名称：");
                    if (addressBook.containsKey(removeName)){
                        addressBook.remove(removeName);
                        ContactStorage.save(addressBook);
                        System.out.println("删除成功");
                    } else {
                        System.out.println("联系人不存在");
                    }
                    break;
                case 3:
                    String oldName = ConsoleInputUtil.readNonEmptyString("请输入要修改联系人名称：");
                    if (addressBook.containsKey(oldName)){
                        User user = addressBook.get(oldName);
                        user.setPhone(ConsoleInputUtil.readNonEmptyString("请输入新的联系人号码："));
                        user.setEmail(ConsoleInputUtil.readNonEmptyString("请输入新的邮箱："));
                        ContactStorage.save(addressBook);
                        System.out.println("修改成功");
                    }else {
                        System.out.println("联系人不存在");
                    }
                    break;
                case 4:
                    String queryName = ConsoleInputUtil.readNonEmptyString("请输入要查询的联系人名称：");
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
                    ContactStorage.saveSync(addressBook);//同步持久化数据,
                    runnning = false;
                    break;
                default:
                    System.out.println("输入错误");
                    break;
            }
        }
        System.out.println("正在关闭系统...");
        ContactStorage.shutdown();//优雅关闭线程池,等线程池所有任务执行完毕，确保数据持久化
        System.out.println("程序已经安全退出！");
    }

}