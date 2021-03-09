import java.util.List;

import static java.lang.System.out;

/**
 * Print a list of numbers
 */
public class FP02Functional {

    private static final List<Integer> NUMBERS = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
    private static final List<String> COURSES =
            List.of("Spring", "Spring Boot", "API" , "Microservices", "AWS", "PCF","Azure", "Docker", "Kubernetes");
    private static final String SEPARATOR = "=============================";


    public static void main(String[] args) {

        out.println("Printing sum of numbers in the list");
        printingSumOfNumbersInTheList();

        out.println(SEPARATOR);
        out.println("Printing maximum number in the list");
        printMaximumNumberInList();

    }

    private static void printingSumOfNumbersInTheList() {
        FP02Functional.NUMBERS.stream()
                .reduce(Integer::sum)
                .ifPresent(out::println);
    }

    private static  void printMaximumNumberInList() {
        FP02Functional.NUMBERS.stream()
                .reduce(Integer::max)
                .ifPresent(out::println);
    }

}
