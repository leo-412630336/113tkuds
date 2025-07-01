 import java.util.Scanner;

public class linear_search_trace {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9}; // 定義整數陣列
        Scanner scanner = new Scanner(System.in); // 建立 Scanner 物件
        
        System.out.print("請輸入要搜尋的數字：");
        int target = scanner.nextInt(); // 讀取使用者輸入的目標數字
        
        boolean found = false; // 標記是否找到目標數字
        int position = -1; // 記錄找到的位置
        
        System.out.println("比對中：");
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%d vs %d\n", target, arr[i]); // 顯示比對過程
            
            if (arr[i] == target) {
                found = true; // 找到目標數字
                position = i; // 記錄位置
                break; // 找到後立即結束迴圈
            }
        }
        
        // 使用 if...else 輸出結果
        if (found) {
            System.out.println("結果：找到 (位置：" + position + ")");
        } else {
            System.out.println("結果：未找到");
        }
        
        scanner.close(); // 關閉 Scanner
    }
} 

