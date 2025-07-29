import java.util.*;

public class F02_YouBikeNextFull {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        int[] times = new int[n];
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().split(":");
            int hour = Integer.parseInt(parts[0]);
            int min = Integer.parseInt(parts[1]);
            times[i] = hour * 60 + min;
        }

        String[] qParts = sc.nextLine().split(":");
        int qHour = Integer.parseInt(qParts[0]);
        int qMin = Integer.parseInt(qParts[1]);
        int queryTime = qHour * 60 + qMin;

        int left = 0, right = n - 1;
        int ans = -1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (times[mid] > queryTime) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if (ans == -1) {
            System.out.println("No bike");
        } else {
            int h = times[ans] / 60;
            int m = times[ans] % 60;
            System.out.printf("%02d:%02d\n", h, m);
        }
    }
}
 // 時間複雜度分析：
// - 讀入 n 筆時間：O(n)
// - 將 HH:mm 轉分鐘格式：O(n)
// - 二分搜尋找第一個 > 查詢時間的項目：O(log n)
//
// => 總時間複雜度：O(n + log n) ≈ O(n)
//
// 空間複雜度分析：
// - 儲存 n 個時間的陣列：O(n)
// - 其他變數空間：O(1)
//
// => 總空間複雜度：O(n)