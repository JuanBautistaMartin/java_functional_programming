import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

/**
 * Print a list of numbers
 */
public class FP05Threads {

    public static void main(String[] args) throws IOException {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<10000; i++) {
                    System.out.println(
                            Thread.currentThread().getId() + ":" + i
                    );
                }
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();

        Thread thread1 = new Thread(runnable);
        thread1.start();

        Thread thread2 = new Thread(runnable);
        thread2.start();


        Runnable runnable2 = () -> {
            for(int i=0; i<10000; i++) {
                System.out.println(
                    Thread.currentThread().getId() + ":" + i);
            }
        };

        Thread thread3 = new Thread(runnable);
        thread3.start();

    }

}
