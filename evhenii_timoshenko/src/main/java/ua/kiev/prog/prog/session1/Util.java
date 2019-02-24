package ua.kiev.prog.prog.session1;

import java.util.stream.Stream;

public class Util {
    public static void printNumbers() {
        Stream.of(1,2,3,4).forEach(System.out::println);
    }
}
