import java.util.Arrays;

public class ArraysPractice {
    public static void main(String[] args) {
        int[] numbers = {5, 2, 9, 1, 5, 6};

        System.out.println("长度: " + numbers.length);
        System.out.println("转字符串: " + Arrays.toString(numbers));
        //复制
        int[] scoresCopy = Arrays.copyOf(numbers, numbers.length);
        System.out.println("复制: " + Arrays.toString(scoresCopy));
        System.out.println("比较: " + Arrays.equals(numbers, scoresCopy));

        //排序
        Arrays.sort(numbers);
        System.out.println("排序后: " + Arrays.toString(numbers));
        //填充
        Arrays.fill(numbers, 0);
        System.out.println("填充后: " + Arrays.toString(numbers));
        System.out.println("副本不受影响: " + Arrays.toString(scoresCopy));


    }
}
