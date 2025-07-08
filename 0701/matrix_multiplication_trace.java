

public class matrix_multiplication_trace {
    public static void main(String[] args) {
        int[][] a = {{1, 2}, {3, 4}}; 
        int[][] b = {{5, 6}, {7, 8}}; 
        int[][] c = new int[2][2];   
        System.out.println("計算過程：");
        for (int i = 0; i < 2; i++) {          
            for (int j = 0; j < 2; j++) {      
                System.out.print("計算位置 c[" + i + "][" + j + "]: ");
                int sum = 0;
                StringBuilder process = new StringBuilder();
                
                for (int k = 0; k < 2; k++) {  
                    int product = a[i][k] * b[k][j];
                    sum += product;
                    
                  
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

