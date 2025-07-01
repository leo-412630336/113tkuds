

public class matrix_multiplication_trace {
    public static void main(String[] args) {
        int[][] a = {{1, 2}, {3, 4}}; // 第一個矩陣
        int[][] b = {{5, 6}, {7, 8}}; // 第二個矩陣
        int[][] c = new int[2][2];    // 結果矩陣

        System.out.println("矩陣相乘計算過程：");
        
        // 三層迴圈實現矩陣乘法
        for (int i = 0; i < 2; i++) {          // 遍歷 a 矩陣的行
            for (int j = 0; j < 2; j++) {      // 遍歷 b 矩陣的列
                System.out.print("計算位置 c[" + i + "][" + j + "]: ");
                int sum = 0;
                StringBuilder process = new StringBuilder();
                
                for (int k = 0; k < 2; k++) {  // 計算內積
                    int product = a[i][k] * b[k][j];
                    sum += product;
                    
                    // 構建計算過程字符串
                    if (k > 0) {
                        process.append(" + ");
                    }
                    process.append(a[i][k]).append("*").append(b[k][j]);
                    process.append(" = ").append(product);
                }
                
                c[i][j] = sum;
                System.out.println(process + " = " + sum);
            }
        }

        System.out.println("\n結果矩陣：");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(c[i][j] + " ");
            }
            System.out.println();
        }
    }
}   

