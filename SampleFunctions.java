import java.util.Scanner;

public class SampleFunctions {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        // Discount section
        System.out.print("Enter T-shirt Price: ");
        double op = keyboard.nextDouble();

        System.out.print("Enter Discount (1%-100%): ");
        double p = keyboard.nextDouble();

        if (p <= 0 || p > 100) {
            System.out.println("Please enter a valid discount percentage.");
        } else {
            double result = SampleFunctions.computeDiscount(op, p);
            System.out.println("Discounted Price (" + p + "%): " + result);
        }

        System.out.print("Enter a character to check if it's a vowel: ");
        char inputChar = keyboard.next().charAt(0); 
                if (SampleFunctions.isVowel(inputChar)) {
            System.out.println(inputChar + " is a vowel.");
        } else {
            System.out.println(inputChar + " is not a vowel.");
        }

        keyboard.close();
    }

    // Compute discount with fixed 20%
    public static double computeDiscount(double originalPrice) {
        return originalPrice - (originalPrice * (20.0 / 100.0));
    }

    // Compute discount with custom percentage
    public static double computeDiscount(double originalPrice, double percent) {
        if (percent > 0 && percent <= 100) {
            return originalPrice - (originalPrice * (percent / 100.0));
        } else {
            return originalPrice; // No discount if invalid percentage
        }
    }

    // Check if a character is a vowel
    public static boolean isVowel(char c) {
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U');
    }
}
