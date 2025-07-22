public class fibonacci{

    public static int fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println("費波納契數列第 " + n + " 項是: " + fibonacci(n));
        // 輸出：費波納契數列第 10 項是: 55
    }
}