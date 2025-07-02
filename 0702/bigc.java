public class bigc {
    public static void main(String[] args) {
        int n = 10; 
        int x = 0;
    System.out.println("\n(c) 三重巢狀迴圈：");
        x = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    x = x + 1;
                }
            }
        }
        System.out.println("x = x + 1 的執行次數: " + x);
        System.out.println("預期執行次數: O(n^3) = " + (n * n * n)); 
}
}
