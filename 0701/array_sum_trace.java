
public class array_sum_trace {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5}; // 定義整數陣列
        int total = 0; // 初始化總和為0
        
        System.out.println("加總過程：");
        for (int i = 0; i < arr.length; i++) {
            int previousTotal = total; // 記錄加總前的值
            total += arr[i]; // 進行加總
            System.out.printf("total = %d + %d = %d\n", previousTotal, arr[i], total);
        }
        
        System.out.println("總和為：" + total);
    }
}   

