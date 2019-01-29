package ua.kiev.prog.prog.session5;


public class ArraysUtilTest {

    public static void main(String[] args) {
        ArraysUtilTest test = new ArraysUtilTest();
        test.testGetArraySumSuccess();
        test.testGetArraySumSingleArg();
        test.testGetArraySumEmpty();
        test.testGetArraySumNull();
    }

    public void testGetArraySumSuccess() {
        ArraysUtil module = new ArraysUtil();

        int actualResuls = module.getArraySum(new int[]{1, 2, 3, 4});
        int expectedResult = 10;
        if (actualResuls == expectedResult) {
            System.out.println("Test Ok");
        } else {
            System.err.println("Test fail!");
        }
    }

    public void testGetArraySumSingleArg() {
        ArraysUtil module = new ArraysUtil();

        int actualResuls = module.getArraySum(new int[]{1});
        int expectedResult = 1;
        if (actualResuls == expectedResult) {
            System.out.println("Test Ok");
        } else {
            System.err.println("Test fail!");
        }
    }

    public void testGetArraySumEmpty() {
        ArraysUtil module = new ArraysUtil();

        int actualResuls = module.getArraySum(new int[]{});
        int expectedResult = 0;
        if (actualResuls == expectedResult) {
            System.out.println("Test Ok");
        } else {
            System.err.println("Test fail!");
        }
    }

    public void testGetArraySumNull() {
        ArraysUtil module = new ArraysUtil();

        try {
            module.getArraySum(null);
            System.err.println("Test fail!");
        } catch (Exception e) {
            System.out.println("Test Ok");
        }

    }
}