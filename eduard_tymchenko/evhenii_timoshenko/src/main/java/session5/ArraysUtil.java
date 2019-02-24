package session5;

// TDD
import java.io.BufferedReader;
import java.util.Arrays;
import java.util.stream.Stream;

public class ArraysUtil {

    private BufferedReader reader;

    public ArraysUtil(BufferedReader reader) {
        this.reader = reader;
    }

    public int getArraySum(int[] vector) {
        //reader = new BufferedReader(new InputStreamReader(System.in));
        Stream<String> lines = reader.lines();
        return Arrays.stream(vector)
                .boxed()
                //.filter(Objects::isNull)
                .reduce(0, (e1, e2) -> e1 + e2);
    }
}
