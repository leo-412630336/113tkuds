import java.util.*;

public class F03_ConvenienceHotItems {
    static class Item {
        String name;
        int qty;

        Item(String name, int qty) {
            this.name = name;
            this.qty = qty;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        Item[] items = new Item[n];
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String name = parts[0];
            int qty = Integer.parseInt(parts[1]);
            items[i] = new Item(name, qty);
        }

        for (int i = 1; i < n; i++) {
            Item key = items[i];
            int j = i - 1;
            while (j >= 0 && items[j].qty < key.qty) {
                items[j + 1] = items[j];
                j--;
            }
            items[j + 1] = key;
        }

        // 輸出前 10 名
        for (int i = 0; i < Math.min(10, n); i++) {
            System.out.println(items[i].name + " " + items[i].qty);
        }
    }
}
// 時間複雜度分析：
// - 讀入 n 筆資料：O(n)
// - 插入排序最壞情況：O(n^2)
// - 輸出前 10 筆：O(1)
//
// => 總時間複雜度：O(n^2)
//
// 空間複雜度分析：
// - 儲存 n 個商品的陣列 items[]：O(n)
// - 其他變數：O(1)
//
// => 總空間複雜度：O(n)