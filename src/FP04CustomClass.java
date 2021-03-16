import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * allMatch, nonMatch, anyMatch
 */
public class FP04CustomClass {

    public static void main(String[] args) {

        List<Course> courses =
                List.of(
                    new Course("Spring", "Framework", 98, 20000),
                    new Course("Spring Boot", "Framework", 95, 18000),
                    new Course("API", "Microservices", 97, 22000),
                    new Course("Microservices", "Microservices", 96, 25000),
                    new Course("FullStack", "Framework", 91, 14000),
                    new Course("AWS", "Cloud", 92, 21000),
                    new Course("Azure", "Cloud", 99, 21000),
                    new Course("Docker", "Cloud", 92, 20000),
                    new Course("Kubernetes", "Cloud", 91, 20000)

                );

        Predicate<Course> reviewScoreGreaterThan95Predicate =
                course -> course.getReviewScore() > 95;

        Predicate<Course> reviewScoreGreaterThan90Predicate =
                course -> course.getReviewScore() > 90;

        Predicate<Course> reviewScoreLessThan90Predicate =
                course -> course.getReviewScore() < 90;

        System.out.println(
                courses.stream()
                        .allMatch(reviewScoreGreaterThan95Predicate));

        System.out.println(
                courses.stream()
                        .noneMatch(reviewScoreGreaterThan95Predicate));

        System.out.println(
                courses.stream()
                        .noneMatch(reviewScoreLessThan90Predicate));

        System.out.println(
                courses.stream()
                        .anyMatch(reviewScoreLessThan90Predicate));

        System.out.println(
                courses.stream()
                        .anyMatch(reviewScoreGreaterThan90Predicate));

        Comparator<Course> compareByNoOfStudentsIncreasing
                = Comparator.comparingInt(Course::getNoOfStudents);
        System.out.println(
                courses.stream()
                        .sorted(compareByNoOfStudentsIncreasing)
                        .collect(Collectors.toList()));

        Comparator<Course> compareByNoOfStudentsDecreasing
                = Comparator.comparingInt(Course::getNoOfStudents).reversed();
        System.out.println(
            courses.stream()
                    .sorted(compareByNoOfStudentsDecreasing)
                    .collect(Collectors.toList())
        );

        Comparator<Course> compareByNoOfStudentsAndNoOfReviews
            = Comparator.comparingInt(Course::getNoOfStudents)
                .thenComparingInt(Course::getReviewScore)
                .reversed();
        System.out.println(
                courses.stream()
                        .sorted(compareByNoOfStudentsAndNoOfReviews)
                        .collect(Collectors.toList())
        );

        // Pick up the top 5 courses
        System.out.println(
                courses.stream()
                        .sorted(compareByNoOfStudentsAndNoOfReviews)
                        .limit(5)
                        .collect(Collectors.toList())
        );

        // Skip top 3 results
        System.out.println(
                courses.stream()
                        .sorted(compareByNoOfStudentsAndNoOfReviews)
                        .skip(3)
                        .collect(Collectors.toList())
        );

        // Skip top 3 results and get the next five courses
        System.out.println(
                courses.stream()
                        .sorted(compareByNoOfStudentsAndNoOfReviews)
                        .skip(3)
                        .limit(5)
                        .collect(Collectors.toList())
        );

        System.out.println(courses);

        //Take all elements until I'll find a element which is having a review course less than 95
        System.out.println(
                courses.stream()
                        .takeWhile(course -> course.getReviewScore() >= 95)
                        .collect(Collectors.toList())
        );

        System.out.println(
                courses.stream()
                        .dropWhile(course -> course.getReviewScore() >= 95)
                        .collect(Collectors.toList())
        );

        // Find the max course defined by max criteria
        // Max return the last element in the list
        System.out.println(
                courses.stream()
                        .max(compareByNoOfStudentsAndNoOfReviews).orElse(null));
        // Min returns the first element in the list
        System.out.println(
                courses.stream()
                        .min(compareByNoOfStudentsAndNoOfReviews).orElse(null));

        //Returning optionalEmpty
        System.out.println(
                courses.stream()
                        .filter(reviewScoreLessThan90Predicate)
                        .min(compareByNoOfStudentsAndNoOfReviews));

        // Returning a default one if there is no course that matches the filter
        System.out.println(
                courses.stream()
                        .filter(reviewScoreLessThan90Predicate)
                        .min(compareByNoOfStudentsAndNoOfReviews)
                        .orElse(
                                new Course("Kubernetes", "Cloud", 91, 20000)
                        )
        );

        // Find the first element which meats a specific criteria
        System.out.println(
                courses.stream()
                        .filter(reviewScoreLessThan90Predicate)
                        .findFirst()
        );

        System.out.println(
                courses.stream()
                        .filter(reviewScoreGreaterThan95Predicate)
                        .findFirst()
        );

        System.out.println(
                courses.stream()
                        .filter(reviewScoreGreaterThan95Predicate)
                        .findAny()
        );

        System.out.println(
                courses.stream()
                        .filter(reviewScoreLessThan90Predicate)
                        .findFirst()
                        .orElse(
                                new Course("Kubernetes", "Cloud", 91, 20000)
                        )
        );
    }

}

class Course {
    private String name;
    private String category;
    private int reviewScore;
    private int noOfStudents;

    public Course(String name, String category, int reviewScore, int noOfStudents) {
        this.name = name;
        this.category = category;
        this.reviewScore = reviewScore;
        this.noOfStudents = noOfStudents;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getReviewScore() {
        return reviewScore;
    }

    public void setReviewScore(int reviewScore) {
        this.reviewScore = reviewScore;
    }

    public int getNoOfStudents() {
        return noOfStudents;
    }

    public void setNoOfStudents(int noOfStudents) {
        this.noOfStudents = noOfStudents;
    }

    public String toString() {
        return name + ":" + noOfStudents + ":" + reviewScore;
    }
}
