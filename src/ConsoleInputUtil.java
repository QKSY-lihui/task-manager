import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * 企业级控制台输入工具类
 * 统一使用 nextLine() 获取输入，避免 Scanner 的换行符残留问
 */
public class ConsoleInputUtil {
    // 静态 Scanner，全局共享
    private static final Scanner scanner = new Scanner(System.in);
    /**
     * 读取用户输入的 安全整数值(有范围限制)
     *
     * @param prompt 提示信息
     * @param min    最小值
     * @param max    最大值
     * @return 用户输入的合法 int 值
     */
    public static int readInt(String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("  [!] 输入不能为空，请重新输入。");
                continue;
            }
            try {
                int value = Integer.parseInt(input);
                if (value < min || value > max) {
                    System.out.println("  [!] 输入超出范围，请输入 " + min + " 到 " + max + " 之间的数字。");
                    continue;
                }
                return value;
            } catch (NumberFormatException e) {
                System.out.println("  [!] 格式错误，请输入有效的整数。");
            }
        }
    }
    /**
     * 读取安全输入的整数（无范围限制）
     *
     */
    public static int readInt(String prompt) {
        return readInt(prompt, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    /**
     * 读取安全输入的小数
     */
    public static double readDouble(String prompt) {
        while (true) {
            System.out.println(prompt);
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("  [!] 输入不能为空，请重新输入。");
                continue;
            }
            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("  [!] 格式错误，请输入有效的数字。");
            }
        }
    }

    /**
     * 安全读取非空字符串
     */
    public static String readNonEmptyString(String prompt) {
        while (true) {
            System.out.println(prompt);
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("  [!] 输入不能为空，请重新输入。");
                continue;
            }
            return input;
        }
    }

    /**
     * 读取布尔值（y/n, yes/no, 是/否）
     */
    public static boolean readBoolean(String prompt) {
        while (true) {
            System.out.println(prompt + " (y/n, yes/no, 是/否): ");
            String input = scanner.nextLine().trim().toLowerCase();
            if ("y".equals(input) || "yes".equals(input) || "是".equals(input)) {
                return true;
            } else if ("n".equals(input) || "no".equals(input) || "否".equals(input)) {
                return false;
            } else {
                System.out.println("  [!] 输入无效，请输入 y/n, yes/no, 是/否。");
            }
        }
    }

    /**
     * 读取日期（格式：YYYY-MM-DD）
     */
    public static LocalDate readDate(String prompt) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        while (true) {
            System.out.println(prompt + " (格式：yyyy-MM-dd): ");
            String input = scanner.nextLine().trim();
            try {
                return LocalDate.parse(input, formatter);
            } catch (Exception e) {
                System.out.println("  [!] 日期格式错误，请输入有效的日期（例如 2023-10-01）。");
            }
        }
    }

    /**
     * 获取底层的 Scanner（特殊情况下使用，例如你要在外部循环读取）
     */
    public static Scanner getScanner() {
        return scanner;
    }
}
