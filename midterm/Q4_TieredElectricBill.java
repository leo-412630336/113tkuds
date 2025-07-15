
import java.util.Scanner;

public class Q4_TieredElectricBill {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] kWhs = new int[n];
        int[] bills = new int[n];

        int total = 0;

        for (int i = 0; i < n; i++) {
            kWhs[i] = sc.nextInt();
            bills[i] = calc(kWhs[i]);
            total += bills[i];
        }

        for (int i = 0; i < n; i++) {
            System.out.println("Bill: $" + bills[i]);
        }
        System.out.println("Total: $" + total);
        double avg = (double) total / n;
        System.out.println("Average: $" + Math.round(avg));

        sc.close();
    }
    public static int calc(int kWh) {
        double sum = 0;

        int[] limits = {120, 330, 500, 700, 1000};
        double[] rates = {1.68, 2.45, 3.70, 5.04, 6.24, 8.46};

        int prev = 0;

        for (int i = 0; i < limits.length; i++) {
            if (kWh > limits[i]) {
                sum += (limits[i] - prev) * rates[i];
                prev = limits[i];
            } else {
                sum += (kWh - prev) * rates[i];
                return (int) Math.round(sum);
            }
        }
        sum += (kWh - prev) * rates[rates.length - 1];

        return (int) Math.round(sum);
    }
}   
/*Time Complexity = O(n) */
