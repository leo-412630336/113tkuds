import java.util.Scanner;
public class q4paircount {
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int pairCount = n * (n - 1) / 2;
        System.out.println(pairCount);
        System.out.println(pairCount);

        sc.close();
    }
}


