import java.util.Arrays;

public class ArrayUtility {

    public static void printArray(int[] array) {
        System.out.println(Arrays.toString(array));
    }

    public static void reverseArray(int[] array) {
        int left = 0;
        int right = array.length - 1;

        while (left < right) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;

            left++;
            right--;
        }
    }

    public static int[] copyArray(int[] array) {
        int[] copy = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            copy[i] = array[i];
        }
        return copy;
    }

    public static int findSecondLargest(int[] array) {
        if (array.length < 2) {
            throw new IllegalArgumentException("陣列中沒有足夠的元素");
        }

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int num : array) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest && num < largest) {
                secondLargest = num;
            }
        }

        if (secondLargest == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("找不到第二大的數值");
        }

        return secondLargest;
    }

    public static void main(String[] args) {
        int[] numbers = {3, 7, 1, 9, 4, 6, 8, 2, 5};

        System.out.println("原始陣列：");
        printArray(numbers);

        int[] copiedArray = copyArray(numbers);
        System.out.println("陣列副本：");
        printArray(copiedArray);

        reverseArray(numbers);
        System.out.println("反轉後陣列：");
        printArray(numbers);

        int secondLargest = findSecondLargest(numbers);
        System.out.println("第二大的數值：" + secondLargest);
    }
}    

