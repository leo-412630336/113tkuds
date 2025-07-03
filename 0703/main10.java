 import java.util.Scanner;
public class main10 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        for (int i = 2; i <= N; i++) {
            if (isPrime(i)) {
                System.out.print(i);
                if (i < N) {
                    System.out.print(" ");
                }
            }
        }
        
        sc.close();
    }

    // 判斷是否為質數
    public static boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}   
