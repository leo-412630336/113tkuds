import java.util.Scanner;

public class FactorialExampleinput {

    public static String getFactorialExpression(int n) {
        if (n == 0 || n == 1) {
            return n + "! = 1";
        }

        StringBuilder expression = new StringBuilder();
        int result = 1;
        expression.append(n).append("! = ");
        for (int i = n; i > 0; i--) {
            result *= i;
            expression.append(i);
            if (i != 1) {
                expression.append(" * ");
            }
        }
        expression.append(" = ").append(result);
        return expression.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("請輸入一個非負整數：");

        if (scanner.hasNextInt()) {
            int input = scanner.nextInt();
            if (input < 0) {
                System.out.println("錯誤：不可輸入負數！");
            } else {
                System.out.println(getFactorialExpression(input));
            }
        } else {
            System.out.println("錯誤：請輸入有效的整數！");
        }

        scanner.close();
    }
}