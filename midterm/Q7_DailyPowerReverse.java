 import java.util.Scanner;

public class Q7_DailyPowerReverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int DAYS = 7;
        int[] usage = new int[DAYS];
        for (int i = 0; i < DAYS; i++) {
            usage[i] = sc.nextInt();
        }
        int left = 0;
        int right = DAYS - 1;
        while (left < right) {
            int temp = usage[left];
            usage[left] = usage[right];
            usage[right] = temp;

            left++;
            right--;
        }
        for (int i = 0; i < DAYS; i++) {
            System.out.print(usage[i] + " ");
        }

    }
}   

