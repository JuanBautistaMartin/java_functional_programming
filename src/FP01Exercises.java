import java.util.List;

import static java.lang.System.*;

/**
 * Print a list of numbers
 */
public class FP01Exercises {

    private static final List<Integer> NUMBERS = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
    private static final List<String> COURSES =
            List.of("Spring", "Spring Boot", "API" , "Microservices", "AWS", "PCF","Azure", "Docker", "Kubernetes");
    private static final String SEPARATOR = "=============================";


    public static void main(String[] args) {

        out.println("Printing odd numbers in the list");
        printOddNumbersInList();

        out.println(SEPARATOR);

        out.println("Printing all courses in the list");
        printAllCoursesInList();

        out.println(SEPARATOR);

        out.println("Printing courses containing Spring word");
        printAllCoursesContainingWordSpringInList();

        out.println(SEPARATOR);

        out.println("Printing all courses whose name has at least 4 letters");
        printAllCoursesWhoseNameHasAtLeast4LettersInList();

        out.println(SEPARATOR);

        out.println("Printing cube of odd numbers in the list");
        printTheCubesOfOddNumbersInList();

        out.println(SEPARATOR);

        out.println("Printing number characters in courses name");
        printNumbersOfCharactersInCoursesNames();

    }

    private static void printOddNumbersInList() {
        FP01Exercises.NUMBERS.stream()
                .filter(number -> number % 2 != 0) // Filtering only odd numbers
                .forEach(out::println); // Method reference
    }

    private static void printAllCoursesInList() {
        FP01Exercises.COURSES.stream()
                .forEach(out::println);
    }

    private static void printAllCoursesContainingWordSpringInList() {
        FP01Exercises.COURSES.stream()
                .filter(course -> course.contains("Spring"))
                .forEach(out::println);
    }

    private static void printAllCoursesWhoseNameHasAtLeast4LettersInList() {
        FP01Exercises.COURSES.stream()
                .filter(course -> course.length() >= 4)
                .forEach(out::println);
    }

    private static void printTheCubesOfOddNumbersInList() {
        FP01Exercises.NUMBERS.stream()
                .filter(number -> number % 2 != 0)
                .map(number -> number * number * number)
                .forEach(out::println);
    }

    private static void printNumbersOfCharactersInCoursesNames() {
        FP01Exercises.COURSES.stream()
                .map(String::length)
                .forEach(out::println);
    }

}
