package ua.kiev.prog.prog;

import java.util.Arrays;

public class Util {
    public static void printNumbers() {
        Arrays.asList(1,2,3,4).stream()
                .forEach(System.out::println);
    }
}
