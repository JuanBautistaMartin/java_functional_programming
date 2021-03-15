import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import static java.lang.System.out;

/**
 * Print a list of numbers
 */
public class FP03FunctionalInterfaces {

    private static final List<Integer> NUMBERS = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
    private static final String SEPARATOR = "=============================";

    public static void main(String[] args) {


        Predicate<Integer> isEvenNumber = x -> x % 2 == 0;
        Function<Integer, Integer> squareFunction = x -> x * x;
        Consumer<Integer> sysOutCOnsumer = System.out::println;

        NUMBERS.stream()
                .filter(isEvenNumber)
                .map(squareFunction)
                .forEach(sysOutCOnsumer);

        out.println(SEPARATOR);

        out.println("Exercise 12");
        exercise12();
    }

    private static void exercise12() {

        BinaryOperator<Integer> binaryOperatorInterface = new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer integer, Integer integer2) {
                return integer + integer2;
            }
        };

        Integer sum = FP03FunctionalInterfaces.NUMBERS.stream()
                .reduce(0, Integer::sum);
        out.println(sum);
    }

}
