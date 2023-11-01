package sd.java.lab1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Lab1Application {
    public Lab1Application() {
    }

    public double run() {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = new int[4];
        // Define an array of strings to represent letters associated with the input prompts
        final String[] letters = new String[]{"n", "m", "a", "b"};

        // Loop to read and validate four integer inputs
        for (int index = 0; index < 4; index++) {
            try {
                // Prompt the user to enter a number
                System.out.print("Enter number " + letters[index] + ": ");
                int input = scanner.nextInt();

                // Check if the input is between 0 and 9 (inclusive)
                if (input >= 0 && input <= 9) {
                    numbers[index] = input; // Store the valid input in the array
                } else {
                    // Display an error message for invalid input and decrement the index to re-enter the value
                    System.out.println("Invalid input. Please enter a valid integer between 0 and 9.");
                    index--;
                }
            } catch (InputMismatchException e) {
                // Catch exception for non-integer input, display an error message, and decrement the index
                System.out.println("Invalid input. Please enter a valid integer between 0 and 9.");
                index--;
                scanner.next(); // Clear the input buffer
            }
        }


        scanner.close();

        // Extract individual values from the 'numbers' array
        final int n = numbers[0];
        final int m = numbers[1];
        final int a = numbers[2];
        final int b = numbers[3];

        double sum = 0;

        // Nested loops to perform calculations
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
