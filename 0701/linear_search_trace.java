 import java.util.Scanner;

public class linear_search_trace {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9}; 
        Scanner scanner = new Scanner(System.in); 
        
        System.out.print("搜尋的數字：");
        int target = scanner.nextInt(); 
        
        boolean found = false; 
        int position = -1; 
        
        System.out.println("比對：");
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%d vs %d\n", target, arr[i]); 
            
            if (arr[i] == target) {
                found = true; 
                position = i; 
                break; 
            }
        }
        
        if (found) {
            System.out.println("結果：找到 (位置：" + position + ")");
        } else {
            System.out.println("結果：未找到");
        }
        
  
    }
} 

