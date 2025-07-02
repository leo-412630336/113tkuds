public class biga {
    public static void main(String[] args) {
        int n = 10; 
        int x = 0;
        System.out.println("(a) 單層迴圈：");
        x = 0;
        for (int i = 1; i <= n; i++) {
            x = x + 1;
        }
        System.out.println("x = x + 1 的執行次數: " + x);
        System.out.println("預期執行次數: O(n) = " + n);

}
}