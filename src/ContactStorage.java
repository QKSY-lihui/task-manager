import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * 联系存储，持久化
 */
public class ContactStorage {
    //定义持久化文件路径（在根目录下）
    private static final Path  FILE_PATH = Path.of("contacts.txt");
    //线程池
    private static final ThreadPoolExecutor executor = new ThreadPoolExecutor(
            1, 1, 0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<>(1000),
            Executors.defaultThreadFactory(),
            new ThreadPoolExecutor.CallerRunsPolicy() // 当线程池满时，由调用线程自己执行任务
    );

    /**
     * 异步存储数据到文件
     */
    public static void save(Map<String, User> addressBook) {
        executor.execute(() -> {
            System.out.println("Saving contacts to file...");
            // 实现将addressBook保存到FILE_PATH文件中
            //格式：name,phone,email
            List<String> lines = addressBook.values().stream()
                    .map(user -> user.getName() + "|" + user.getPhone() + "|" + user.getEmail())
                    .collect(Collectors.toList());// 企业里兼容性更好的写法
            //.toList();//jdk17才开始使用
            try {
                Files.write(FILE_PATH, lines);
                System.out.println("保存文件成功");
            } catch (IOException e) {
                System.out.println("保存文件失败：" + e.getMessage());;
            }
        });
    }

    /**
     * 同步存储数据到文件（供程序退出时兜底调用）
     */
    public static void saveSync(Map<String, User> addressBook) {
        System.out.println("Saving contacts to file...");
        // 实现将addressBook保存到FILE_PATH文件中
        //格式：name,phone,email
        List<String> lines = addressBook.values().stream()
                .map(user -> user.getName() + "|" + user.getPhone() + "|" + user.getEmail())
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
            for (String line : lines) {
                // 跳过空行，等价于(line.isEmpty()||line=="")
                if (line.trim().isEmpty()) {continue;}
                // 注意：split("|") 在正则里是特殊字符，必须转义写成 split("\\|")
                String[] parts = line.split("\\|");
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

    /**
     * 优雅关闭线程池
     */
    public static void shutdown() {
        executor.shutdown();//拒绝新任务，等待已提交的任务执行完
        try {
            if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {//等待5秒，如果超时则关闭
                System.out.println("警告：线程池关闭超时5秒，正在强制关闭");
                executor.shutdownNow();//拒绝新任务，立即关闭
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            //恢复中断状态
            Thread.currentThread().interrupt();
        }
    }
}
