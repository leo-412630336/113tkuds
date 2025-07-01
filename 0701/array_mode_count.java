 import java.util.HashMap;
import java.util.Map;


public class array_mode_count {
    public static void main(String[] args) {
        int[] arr = {3, 7, 3, 1, 1, 1};
        Map<Integer, Integer> countMap = new HashMap<>();
        
        
        for (int num : arr) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            System.out.printf("比對中：%d 出現次數 = %d\n", num, countMap.get(num));
        }
        
        
        int mode = arr[0];
        int maxCount = 0;
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mode = entry.getKey();
            }
        }
        
        System.out.printf("眾數為：%d，出現 %d 次\n", mode, maxCount);
    }
}  

