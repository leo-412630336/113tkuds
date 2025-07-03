import java.util.Scanner;

public class SumIntAndDouble {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int intNumber = sc.nextInt();
        double doubleNumber = sc.nextDouble();
        double sum = intNumber + doubleNumber;
        System.out.printf("%.2f\n", sum);

        sc.close();
    }
}
