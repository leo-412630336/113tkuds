import java.util.Scanner;
public class q5matrixmul {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 讀取 n
        int n = sc.nextInt();

        int[][] A = new int[n][n];
        int[][] B = new int[n][n];
        int[][] C = new int[n][n];

        // 讀取矩陣 A
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                A[i][j] = sc.nextInt();
            }
        }

        // 讀取矩陣 B
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                B[i][j] = sc.nextInt();
            }
        }

        // 計算矩陣相乘 C = A * B
        for (int i = 0; i < n; i++) {         // 每一列
            for (int j = 0; j < n; j++) {     // 每一欄
                int sum = 0;
                for (int k = 0; k < n; k++) { // 內積
                    sum += A[i][k] * B[k][j];
                }
                C[i][j] = sum;
            }
        }

        // 輸出矩陣 C
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(C[i][j]);
                if (j != n - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        // 計算操作次數（乘法 + 加法）
        int ops = n * n * 2; // 每個元素 1 乘法 + 1 加法，共 n² 個元素
        System.out.println(ops);

        sc.close();
    }
}


