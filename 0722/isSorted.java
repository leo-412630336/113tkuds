public class isSorted {

    public static boolean isSorted(int[] arr, int index) {
        if (index >= arr.length - 1) {
            return true;
        }
        if (arr[index] > arr[index + 1]) {
            return false;
        }
        return isSorted(arr, index + 1);
    }

    public static void main(String[] args) {
        int[] sortedArray = {1, 2, 3, 4, 5};
        int[] unsortedArray = {3, 2, 5, 4, 6};

        System.out.println("sortedArray 已排序嗎？" + isSorted(sortedArray, 0));     // true
        System.out.println("unsortedArray 已排序嗎？" + isSorted(unsortedArray, 0)); // false
    }
}