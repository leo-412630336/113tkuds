import java.util.*;

public class F06_ArraySecondLargest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Pair result = findSecondMax(arr, 0, n - 1);
        System.out.println("SecondMax: " + result.second);
    }

    static class Pair {
        int first; 
        int second;

        Pair(int f, int s) {
            first = f;
            second = s;
        }
    }

    // 遞迴找出最大與次大值
    public static Pair findSecondMax(int[] arr, int left, int right) {
        if (left == right) {
            return new Pair(arr[left], Integer.MIN_VALUE); 
        }

        int mid = (left + right) / 2;
        Pair leftPair = findSecondMax(arr, left, mid);
        Pair rightPair = findSecondMax(arr, mid + 1, right);

        int max, second;

        if (leftPair.first > rightPair.first) {
            max = leftPair.first;
            second = Math.max(leftPair.second, rightPair.first);
        } else {
            max = rightPair.first;
            second = Math.max(rightPair.second, leftPair.first);
        }

        return new Pair(max, second);
    }
}
// 時間複雜度分析：
// - 使用 Divide and Conquer：每次劃分成左右兩半，進行比較與合併
// - 每層遞迴合併最多做常數次比較
// - 遞迴樹高度為 log n，共有 n 個元素參與比較
//
// => 總時間複雜度：O(n)
//
// 空間複雜度分析：
// - 遞迴深度為 log n（遞迴棧）
// - 其他變數與 Pair 儲存為 O(1)
//
// => 總空間複雜度：O(log n)5
