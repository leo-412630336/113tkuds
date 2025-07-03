import java.util.Scanner;
public class main5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[][] matrix = new int[N][N];

        int num = 1;             // 從 1 開始填充
        int top = 0;
        int bottom = N - 1;
        int left = 0;
        int right = N - 1;

        while (num <= N * N) {
            // 往右填充
            for (int i = left; i <= right && num <= N * N; i++) {
                matrix[top][i] = num++;
            }
            top++;

            // 往下填充
            for (int i = top; i <= bottom && num <= N * N; i++) {
                matrix[i][right] = num++;
            }
            right--;

            // 往左填充
            for (int i = right; i >= left && num <= N * N; i--) {
                matrix[bottom][i] = num++;
            }
            bottom--;

            // 往上填充
            for (int i = bottom; i >= top && num <= N * N; i--) {
                matrix[i][left] = num++;
            }
            left++;
        }

        // 輸出矩陣
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(matrix[i][j]);
                if (j != N - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        sc.close();
    }
}    

