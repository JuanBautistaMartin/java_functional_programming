import java.util.List;

/**
 * Print a list of numbers
 */
public class FP01Functional {

    public static void main(String[] args) {

        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

        System.out.println("Print all numbers in the list");
        printAllNumbersInListFunctional(numbers);

        System.out.println("==============================================");

        System.out.println("Print even numbers in the list");
        printEvenNumbersInListFunctional(numbers);

    }

    private static void printAllNumbersInListFunctional(List<Integer> numbers) {
        numbers.stream()
                .forEach(System.out::println); // Method reference
    }

    private static void printEvenNumbersInListFunctional(List<Integer> numbers) {
        numbers.stream()
                .filter(number -> number % 2 == 0) // Filtering only even numbers
                .forEach(System.out::println); // Method reference
    }

}
