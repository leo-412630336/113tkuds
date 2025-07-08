public class ArrayStatistics {
    public static int calculateSum(int[] array) {
        int sum = 0;
        for (int num : array) {
            sum += num;
        }
        return sum;
    }
    public static double calculateAverage(int[] array) {
        int sum = calculateSum(array);
        return (double) sum / array.length;
    }
    public static int[] findMax(int[] array) {
        int max = array[0];
        int index = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
                index = i;
            }
        }
        return new int[] {max, index};
    }
    public static int[] findMin(int[] array) {
        int min = array[0];
        int index = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
                index = i;
            }
        }
        return new int[] {min, index};
    }
    public static int countAboveAverage(int[] array, double average) {
        int count = 0;
        for (int num : array) {
            if (num > average) {
                count++;
            }
        }
        return count;
    }
    public static int[] countEvenOdd(int[] array) {
        int even = 0;
        int odd = 0;
        for (int num : array) {
            if (num % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        return new int[] {even, odd};
    }

    public static void main(String[] args) {
        int[] numbers = {5, 12, 8, 15, 7, 23, 18, 9, 14, 6};
        int sum = calculateSum(numbers);
        double average = calculateAverage(numbers);
        int[] maxResult = findMax(numbers);
        int[] minResult = findMin(numbers);
        int aboveAverage = countAboveAverage(numbers, average);
        int[] evenOdd = countEvenOdd(numbers);
        System.out.printf("%-20s : %d%n", "總和", sum);
        System.out.printf("%-20s : %.2f%n", "平均值", average);
        System.out.printf("%-20s : %d (索引: %d)%n", "最大值", maxResult[0], maxResult[1]);
        System.out.printf("%-20s : %d (索引: %d)%n", "最小值", minResult[0], minResult[1]);
        System.out.printf("%-20s : %d%n", "大於平均值的數量", aboveAverage);
        System.out.printf("%-20s : %d%n", "偶數的數量", evenOdd[0]);
        System.out.printf("%-20s : %d%n", "奇數的數量", evenOdd[1]);
        System.out.println("==========================");
    }
}    

