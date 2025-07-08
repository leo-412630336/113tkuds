
public class array_sum_trace {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5}; 
        int total = 0; 
        System.out.println(" 過程：");
        for (int i = 0; i < arr.length; i++) {
            int previousTotal = total; 
            total += arr[i]; 
            System.out.printf("total = %d + %d = %d\n", previousTotal, arr[i], total);
        }
        System.out.println("和為：" + total);
    }
}   

