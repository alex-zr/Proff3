package ua.kiev.prog.prog.session5;


import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.StringReader;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class ArraysJUtilTest {
    private ArraysUtil module;

    @Before
    public void setUp() {
        module = new ArraysUtil(new BufferedReader(new StringReader("")));
    }

    @Test
    public void testGetArraySumSuccess() {
        int actualResuls = module.getArraySum(new int[]{1, 2, 3, 4});
        assertSame(10, actualResuls);
    }

    @Test
    public void testGetArraySumSingleArg() {
        int actualResuls = module.getArraySum(new int[]{1});
        assertEquals(1, actualResuls);
    }

    @Test
    public void testGetArraySumEmpty() {
        int actualResuls = module.getArraySum(new int[]{});
        assertEquals(0, actualResuls);
    }

    @Test(expected = NullPointerException.class)
    public void testGetArraySumNull() {
        module.getArraySum(null);
    }
}