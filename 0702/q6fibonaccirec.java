import java.util.Scanner;
public class q6fibonaccirec {
    static int callCount = 0; // 用來記錄遞迴呼叫次數

    public static int fib(int n) {
        callCount++; // 每次呼叫都+1
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int result = fib(n);
        System.out.println(result);
        System.out.println(callCount);

        sc.close();
    }
}

