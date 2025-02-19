package Calculator;


import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter X\nEnter Operator\nEnter Y ");
        final float[] a = new float[1];
        final float[] b = new float[1];
        final char[] o = new char[1];
        Calculator c = new Calculator() {
            @Override
            public void input() {
                Scanner sc = new Scanner(System.in);

                boolean flag = true;
                int i = 0;
                while (flag && i < 3) {
                    try {
                        a[0] = sc.nextFloat();
                        o[0] = sc.next().charAt(0);
                        b[0] = sc.nextFloat();
                        flag = false;
                    } catch (InputMismatchException e) {
                        i++;
                        System.out.println("Invalid Input!!.\nEnter X\nEnter Operator\nEnter Y ");
                        sc.nextLine(); // Consume the invalid input
                    }
                }
            }

            @Override
            public void output() {
                switch (o[0]){
                    case '+' -> System.out.printf("%.2f", Operator.ADD.apply(a[0], b[0]));
                    case '-' -> System.out.printf("%.2f", Operator.SUBTRACT.apply(a[0], b[0]));
                    case '*' -> System.out.printf("%.2f", Operator.MULTIPLY.apply(a[0], b[0]));
                    case '/' -> {
                        try{
                            System.out.printf("%.2f", Operator.DIVIDE.apply(a[0], b[0]));
                        }
                        catch (ArithmeticException e){
                            System.out.println("division by zero is impossible");
                        }
                    }
                    case '%' -> {
                        try{
                            System.out.printf("%.2f", Operator.REMINDER.apply(a[0], b[0]));
                        }
                        catch (ArithmeticException e){
                            System.out.println("division by zero is impossible");
                        }
                    }
                    default -> System.out.println("Not a valid Operation");
                }
            }
        };
        c.input();
        c.output();
    }
}