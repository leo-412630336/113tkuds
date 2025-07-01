import java.util.Scanner;
public class scarch{
    public static void main(String[] args) {
        int[] s = {1, 3, 5, 7, 9, 11, 13}; 
        Scanner scanner = new Scanner(System.in);

        System.out.print("查找的數字：");
        int x = scanner.nextInt();
        boolean found = false;
        for (int num : s) {
            System.out.println("比對: " + num + " 和 " + x);
            if (num == x) {
                found = true;
                break;
            }
        }

        System.out.print("true");
    }

}
