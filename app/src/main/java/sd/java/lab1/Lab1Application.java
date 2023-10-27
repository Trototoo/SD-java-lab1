package sd.java.lab1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Lab1Application {
    public Lab1Application() {
    }

    public double run() {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = new int[4];
        final String[] letters = new String[]{"n", "m", "a", "b"};

        for (int index = 0; index < 4; index++) {
            try {
                System.out.print("Enter number " + letters[index] + ": ");
                int input = scanner.nextInt();

                if (input >= 0 && input <= 9) {
                    numbers[index] = input;
                } else {
                    System.out.println("Invalid input. Please enter a valid integer between 0 and 9.");
                    index--;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer between 0 and 9.");
                index--;
                scanner.next();
            }
        }

        scanner.close();

        final int n = numbers[0];
        final int m = numbers[1];
        final int a = numbers[2];
        final int b = numbers[3];

        double sum = 0;

        for (char i = Character.forDigit(a, 10); i <= Character.forDigit(n, 10); i++) {
            for (char j = Character.forDigit(b, 10); j <= Character.forDigit(m, 10); j++) {
                double numerator = Integer.parseInt(String.valueOf(i)) % Integer.parseInt(String.valueOf(j));
                double denominator = Integer.parseInt(String.valueOf(i)) + 1;

                sum += numerator/denominator;
            }
        }

        return sum;
    }
}
