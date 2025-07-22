public class FactorialExample {

    public static String getFactorialExpression(int n) {
        if (n < 0) {
            return "無效輸入";
        } else if (n == 0 || n == 1) {
            return n + "! = 1";
        }

        StringBuilder expression = new StringBuilder();
        int result = 1;
        expression.append(n).append("! = ");

        for (int i = n; i > 0; i--) {
            result *= i;
            expression.append(i);
            if (i != 1) {
                expression.append(" * ");
            }
        }

        expression.append(" = ").append(result);
        return expression.toString();
    }

    public static void main(String[] args) {
        System.out.println(getFactorialExpression(3)); 
        System.out.println(getFactorialExpression(5));
        System.out.println(getFactorialExpression(0));
    }
}
