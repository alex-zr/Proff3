package ua.kiev.prog.session5;



public class ArraysUtilTest {

    public static void main(String arg[]){
        ArraysUtilTest test = new ArraysUtilTest();
        test.testGetArraySumSuccess();
        test.testGetArraySumSingleArg();
        test.testGetArraySumSNull();




    }

    public void testGetArraySumSuccess() {
        // в тесті зажвди має бути створено новий обєкт класу
        // happycase = success result

        ArraysUtil module = new ArraysUtil();

        int actualResult = module.getArraySum(new int[]{1,2,3,4});
        int expectedResults = 10;

        if(actualResult == expectedResults){
            System.out.println("Test OK");
        }else{
            System.out.println("Test Failed");

        }



    }


    public void testGetArraySumSingleArg() {
        // перевірка методів з аргументами мін-макс можливими
        // cornercase = success result

        ArraysUtil module = new ArraysUtil();

        int actualResult = module.getArraySum(new int[]{1});
        int expectedResults = 1;

        if(actualResult == expectedResults){
            System.out.println("Test OK");
        }else{
            System.out.println("Test Failed");

        }



    }

    public void testGetArraySumSNull() {
        // перевірка методів з аргументами мін-макс можливими
        // cornercase = success result

        ArraysUtil module = new ArraysUtil();

        int actualResult = module.getArraySum(new int[]{1});
        int expectedResults = 1;

        if(actualResult == expectedResults){
            System.out.println("Test OK");
        }else{
            System.out.println("Test Failed");

        }



    }


}