import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.lang.System.out;

/**
 * Print a list of numbers
 */
public class FP03BehaviourParametrization {

    private static final List<Integer> NUMBERS = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
    private static final String SEPARATOR = "=============================";

    public static void main(String[] args) {
        out.println(SEPARATOR);

        out.println("Exercise 13");
        exercise13(x -> x * x);
    }

    private static void exercise13(Function<Integer, Integer> function) {
        List<Integer> squares =
                FP03BehaviourParametrization.NUMBERS.stream()
                    .map(function)
                    .collect(Collectors.toList());
        out.println(squares);
    }

}
