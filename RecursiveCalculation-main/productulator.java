import java.util.Scanner;

public class Productulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[5];
        
        // Get 5 numbers
        System.out.println("Enter 5 numbers:");
        for (int i = 0; i < 5; i++) {
            System.out.print((i + 1) + ": ");
            numbers[i] = scanner.nextInt();
        }
        
        // Calculate
        int product = calcProduct(numbers, 0, 1);
        System.out.println("The product is: " + product);
    }
    
    // Recursive method 
    public static int calcProduct(int[] numbers, int index, int product) {
        // Base case
        if (index == numbers.length) {
            return product;
        }
        // Current number times accumulated product
        return calcProduct(numbers, index + 1, product * numbers[index]);
    }
}