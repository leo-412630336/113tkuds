import java.util.Scanner;

public class Q9_FindFiveStarStalls {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] scores = new int[n];
        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextInt();
        }

        // Step 1: 計算評分為 5 的攤位數
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (scores[i] == 5) {
                count++;
            }
        }

        // Step 2: 沒有找到就印 None
        if (count == 0) {
            System.out.println("None");
            return;
        }

        // Step 3: 再次走訪，存放索引
        int[] idxs = new int[count];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            if (scores[i] == 5) {
                idxs[idx++] = i;
            }
        }

        // Step 4: 輸出
        for (int i = 0; i < count; i++) {
            System.out.print(idxs[i]);
            if (i != count - 1) {
                System.out.print(" ");
            }
        }
    }
}