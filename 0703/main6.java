import java.util.Scanner;

public class main6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] matrix = new int[N][M];
        int[][] transpose = new int[M][N];

        // 輸入矩陣
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        // 計算轉置
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                transpose[j][i] = matrix[i][j];
            }
        }

        // 輸出轉置後的矩陣
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(transpose[i][j]);
                if (j != N - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        sc.close();
    }
}

