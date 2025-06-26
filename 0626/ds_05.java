public class ds_05 {
    public static void main(String[] args) {
        int[] numbers = {3, 5, 8, 2, 9, 1, 4, 7, 6, 10};

        int sum = 0; 
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        System.out.println("陣列所有元素的總和是：" + sum);
    }
}