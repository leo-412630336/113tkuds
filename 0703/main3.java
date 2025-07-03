 import java.util.Scanner;
public class main3 {
 public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int M = sc.nextInt();
        
        int[][] arr = new int[N][M];
                for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        
        int[] colSum = new int[M];
        for (int j = 0; j < M; j++) {
            int sum = 0;
            for (int i = 0; i < N; i++) {
                sum += arr[i][j];
            }
            colSum[j] = sum;
        }
        
        for (int j = 0; j < M; j++) {
            System.out.print(colSum[j]);
            if (j != M - 1) {
                System.out.print(" ");
            }
        }
        
        sc.close();
    }
}   

