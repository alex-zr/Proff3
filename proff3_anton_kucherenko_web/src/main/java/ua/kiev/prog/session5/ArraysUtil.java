package ua.kiev.prog.session5;


//TDD  =  Test Driven Development

import java.util.Arrays;

public class ArraysUtil {

    public int getArraySum(int[] vector) {

        return Arrays.stream(vector)
                .boxed()
                .reduce(0, (e1, e2) -> e1 + e2);


    }
}
