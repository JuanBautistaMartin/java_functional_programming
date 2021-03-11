import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Print a list of numbers
 */
public class FP03FunctionalInterfaces {

    public static void main(String[] args) {

        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

        Predicate<Integer> isEvenNumber = x -> x % 2 == 0;
        Function<Integer, Integer> squareFunction = x -> x * x;
        Consumer<Integer> sysOutCOnsumer = System.out::println;
        
        numbers.stream()
                .filter(isEvenNumber)
                .map(squareFunction)
                .forEach(sysOutCOnsumer);
    }

}
