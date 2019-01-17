package ua.kiev.prog.session1;

import java.util.Arrays;

public class Util {
    public static void printNumbers() {
        Arrays.asList(1,2,3,4).stream()
                .forEach(System.out::println);
    }
}
