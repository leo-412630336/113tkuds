import java.util.*;

public class F01_TMRTStopCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 停靠站數
        ArrayList<String> stops = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            stops.add(sc.next());
        }

        String start = sc.next();
        String end = sc.next();

        int index1 = stops.indexOf(start);
        int index2 = stops.indexOf(end);

        if (index1 == -1 || index2 == -1) {
            System.out.println("Invalid");
        } else {
            System.out.println(Math.abs(index1 - index2) + 1);
        }
    }
}
// 整體時間複雜度：O(n)
// 整體空間複雜度：O(n)