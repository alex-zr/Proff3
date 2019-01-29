package ua.kiev.prog.session5;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ArraySumTest {
    ArraySum module;

    @Before
    public void init() {
        module = new ArraySum();
    }

    @Test
    public void testGetArraySumSuccess() {
        int actualResult = module.getArraySum(new int[]{1, 2, 3, 4});
        assertEquals(10, actualResult);
    }

    @Test
    public void testGetArraySumSingleArg() {
        int actualResult = module.getArraySum(new int[]{1});
        assertEquals(1, actualResult);
    }

    @Test
    public void testGetArrarSumEmpty() {
        int actualResult = module.getArraySum(new int[]{});
        assertEquals(0, actualResult);
    }

    @Test (expected = NullPointerException.class)
    public void testGetArraySumNull() {
        module.getArraySum(null);
    }
}