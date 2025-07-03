
 import java.util.Scanner;

public class main12 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double radius = sc.nextDouble();
        double pi = 3.14;

        double area = pi * radius * radius;

        System.out.printf("%.2f\n", area);

        sc.close();
    }
}   

