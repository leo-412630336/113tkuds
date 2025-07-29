import java.util.*;

public class F05_LCMRecursive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        int gcd = recursiveGCD(a, b);
        int lcm = a * b / gcd;

        System.out.println("LCM: " + lcm);
    }

    public static int recursiveGCD(int a, int b) {
        if (a == b)
            return a;
        if (a > b)
            return recursiveGCD(a - b, b);
        else
            return recursiveGCD(a, b - a);
    }
}
// 時間複雜度分析：
// - recursiveGCD(a, b) 為輾轉**相減**法
//   最壞情況下可能需 O(a + b) 次遞迴（例如 a=1, b=n）
// - 最小公倍數計算與輸出皆為 O(1)
//
// => 總時間複雜度：O(a + b)
//
// 空間複雜度分析：
// - 遞迴呼叫堆疊最多 O(a + b) 層
// - 其他變數空間：O(1)
//
// => 總空間複雜度：O(a + b)