import java.util.Scanner;
public class q7permutation {
    static int count = 0; 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        permute(arr, 0);
        System.out.println(count);
    }

    public static void permute(int[] arr, int k) {
        if (k == arr.length) {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i]);
                if (i != arr.length - 1) System.out.print(" ");
            }
            System.out.println();
            count++;
        } else {
            for (int i = k; i < arr.length; i++) {
                swap(arr, i, k);
                permute(arr, k + 1);
                swap(arr, i, k); 
            }
        }
    }
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}   

