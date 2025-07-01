public class matrix {
    public static void main(String[] args) {
        int[][] a = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        int[][] b = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        int[][] c = new int[3][3];

        // 矩陣相乘
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        }

        // 輸出格式
        for (int i = 0; i < 3; i++) {
            // A
            for (int j = 0; j < 3; j++) {
                System.out.printf("%3d", a[i][j]);
            }

            // 中間列印 X
            if (i == 1) {
                System.out.printf("   x ");
            } else {
                System.out.printf("     ");
            }

            // B
            for (int j = 0; j < 3; j++) {
                System.out.printf("%3d", b[i][j]);
            }

            // 中間列印 =
            if (i == 1) {
                System.out.printf("   = ");
            } else {
                System.out.printf("     ");
            }

            // C
            for (int j = 0; j < 3; j++) {
                System.out.printf("%4d", c[i][j]);
            }

            System.out.println();
        }
    }
}
