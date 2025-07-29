import java.util.*;

public class F04_TieredIncomeTax {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        long totalTax = 0;
        for (int i = 0; i < n; i++) {
            long income = Long.parseLong(sc.nextLine().trim());
            long tax = computeTax(income);
            totalTax += tax;
            System.out.println("Tax: $" + tax);
        }

        long avg = totalTax / n;
        System.out.println("Average: $" + avg);
    }

    public static long computeTax(long income) {
        if (income <= 540000)
            return Math.round(income * 0.05);
        else if (income <= 1210000)
            return Math.round(income * 0.12 - 37800);
        else if (income <= 2420000)
            return Math.round(income * 0.20 - 134600);
        else if (income <= 4530000)
            return Math.round(income * 0.30 - 376600);
        else
            return Math.round(income * 0.40 - 829600);
    }
}
// 時間複雜度分析：
// - 讀取 n 筆收入資料：O(n)
// - 每筆呼叫 computeTax() 為常數時間：O(1)
// - 平均稅額計算與輸出：O(1)
//
// => 總時間複雜度：O(n)
//
// 空間複雜度分析：
// - 僅使用少量變數（收入、稅額、加總等）：O(1)
//
// => 總空間複雜度：O(1)