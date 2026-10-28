import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 联系存储，持久化
 */
public class ContactStorage {
    //定义持久化文件路径（在根目录下）
    private static final Path  FILE_PATH = Path.of("contacts.txt");

    /**
     * 存储数据到文件
     */
    public static void save(Map<String, User> addressBook) {
        System.out.println("Saving contacts to file...");
        // 实现将addressBook保存到FILE_PATH文件中
        //格式：name,phone,email
        List<String> lines = addressBook.values().stream()
                .map(user -> user.getName() + "," + user.getPhone() + "," + user.getEmail())
                .collect(Collectors.toList());// 企业里兼容性更好的写法
                //.toList();//jdk17才开始使用
        try {
            Files.write(FILE_PATH, lines);
            System.out.println("保存文件成功");
        } catch (IOException e) {
            System.out.println("保存文件失败：" + e.getMessage());;
        }
    }

    /**
     * 从文件中读取数据
     */
    public static Map<String, User> load() {
        System.out.println("Loading contacts from file...");
        // 实现从FILE_PATH文件中读取数据
        //必须初始化，否则会报空指针异常
        Map<String, User> addressBook = new HashMap<>();
        // 如果文件不存在，返回空的addressBook
        if (!Files.exists(FILE_PATH)) {
            return addressBook;
        }
        try {
            List<String> lines = Files.readAllLines(FILE_PATH);
            System.out.println(lines.toString());
            for (String line : lines) {
                // 跳过空行，等价于(line.isEmpty()||line=="")
                if (line.trim().isEmpty()) {continue;}
                String[] parts = line.split(",");
                // 防止文件被手动改坏导致数组越界
                if (parts.length == 3) {
                    String name = parts[0];
                    String phone = parts[1];
                    String email = parts[2];
                    addressBook.put(name, new User(name, phone, email));
                }
            }
            System.out.println("数据加载成功，共读取 " + addressBook.size() + " 条联系人。");

        } catch (IOException e) {
            System.out.println("读取文件失败：" + e.getMessage());;
        }
        return addressBook;
    }
}
