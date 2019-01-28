package ua.kiev.prog.session5;

import java.util.Arrays;
import java.util.Objects;

public class ArraySum {
    public int getArraySum(int[] vector){
        return Arrays.stream(vector).boxed()
                //.filter(Objects::isNull)
                .reduce(0, (e1, e2) -> e1 + e2);
    }
}
