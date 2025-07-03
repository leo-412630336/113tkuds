import java.util.Scanner;

public class CelsiusToFahrenheit{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double celsius = sc.nextDouble();
        int fahrenheit = (int) ((celsius * 9 / 5) + 32);

        System.out.println( fahrenheit);

    }
}

