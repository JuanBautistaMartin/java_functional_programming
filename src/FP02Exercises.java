import java.util.List;
import java.util.stream.Collectors;

import static java.lang.System.out;

/**
 * Print a list of numbers
 */
public class FP02Exercises {

    private static final List<Integer> NUMBERS = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
    private static final List<String> COURSES =
            List.of("Spring", "Spring Boot", "API" , "Microservices", "AWS", "PCF","Azure", "Docker", "Kubernetes");
    private static final String SEPARATOR = "=============================";


    public static void main(String[] args) {

        out.println("Square every number in a list and find the sum of squares");
        squareEveryNumberAndSumTheSquares();

        out.println(SEPARATOR);

        out.println("Cube every number in a list and find the sum of cubes");
        cubeEveryNumberAndSumTheSquares();

        out.println(SEPARATOR);

        out.println("Find Sum of Odd Numbers in a list");
        sumOddNumbersInList();

        out.println(SEPARATOR);

        out.println("Create a List with Even Numbers Filtered from the Numbers List");
        List<Integer> evenNumbersList = createListWithEvenNumbersInList();
        out.println(evenNumbersList);

        out.println(SEPARATOR);

        out.println("Create a List with length of course titles");
        List<Integer> coursesLengthList = createListWithLengthOfCourseTitles();
        out.println(coursesLengthList);

    }

    // # Exercise 7
    // Square every number in a list and find the sum of squares
    private static void squareEveryNumberAndSumTheSquares() {
        Integer squareSum = FP02Exercises.NUMBERS.stream()
                .map(number -> number * number)
                .reduce(0, Integer::sum);
        out.println(squareSum);
    }

    // # Exercise 8
    // Cube every number in a list and find the sum of cubes
    private static void cubeEveryNumberAndSumTheSquares() {
        Integer cubeSum =
                FP02Exercises.NUMBERS.stream()
                    .map(number -> number * number * number)
                    .reduce(0, Integer::sum);
        out.println(cubeSum);
    }

    // # Exercise 9
    // Find Sum of Odd Numbers in a list
    private static void sumOddNumbersInList() {
        Integer oddNumbersSum =
                FP02Exercises.NUMBERS.stream()
                        .filter(number -> number % 2 != 0)
                        .reduce(0, Integer::sum);
        out.println(oddNumbersSum);
    }

    // # Exercise 10
    // Create a List with Even Numbers Filtered from the Numbers List
    private static List<Integer> createListWithEvenNumbersInList() {
        return FP02Exercises.NUMBERS.stream()
                .filter(number -> number % 2 == 0)
                .collect(Collectors.toList());
    }

    // # Exercise 11
    // Create a List with lengths of all course titles.
    private static List<Integer> createListWithLengthOfCourseTitles() {
        return FP02Exercises.COURSES.stream()
                .map(course -> course.length())
                .collect(Collectors.toList());
    }

}
