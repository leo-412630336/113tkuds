import java.util.Scanner;

public class Q2_NextTHSRDeparture {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine(); 
         int[] times = new int[n];
        String[] originalTimes = new String[n]; 
         for (int i = 0; i < n; i++) {
            String timeStr = sc.nextLine();
            originalTimes[i] = timeStr;
            times[i] = timeToMinutes(timeStr);
        }

        String queryStr = sc.nextLine();
        int query = timeToMinutes(queryStr);

        int idx = binarySearch(times, query);

        if (idx == n) {
            System.out.println("No train");
        } else {
            System.out.println(originalTimes[idx]);
        }

    }

    public static int timeToMinutes(String time) {
        String[] parts = time.split(":");
        int hh = Integer.parseInt(parts[0]);
        int mm = Integer.parseInt(parts[1]);
        return hh * 60 + mm;
    }

    public static int binarySearch(int[] arr, int query) {
        int left = 0;
        int right = arr.length; 
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] > query) {
                right = mid; 
            } else {
                left = mid + 1; 
            }
        }
        return left;
    }
}   
/*Time Complexity = O(n + log n) ≈ O(n) */