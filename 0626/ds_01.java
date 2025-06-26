import java.util.Scanner;

public class ds_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("第一整數：");
        int num1 = scanner.nextInt();
        System.out.print("第二整數：");
        int num2 = scanner.nextInt();
        int sum = num1 + num2;
        System.out.println("總和是：" + sum);
        scanner.close();
    }
}