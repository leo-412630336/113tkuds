public class ArryDemo {
    public static void main(String[] args) {
        double[] numbers = {0.1, 92.21, 77.4, 60.2, 88.9};
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("Index"+i);
            System.out.println(numbers[i]);
            System.out.println("佔用位元"+Double.BYTES+"bytes");
        }
    }
}
