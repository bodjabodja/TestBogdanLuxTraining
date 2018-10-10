package Tests;

import collection.Calculator;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by dsk16 on 10/9/2018.
 */
public class CalculatorTest {

    @Test
    public void testSum(){
        Calculator calculator = new Calculator();
        int expected = 5;

        int actual = calculator.sum(2,3);

        //compare
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testDevide(){
        Calculator calculator = new Calculator();
        int expected = 10;

        int actual = calculator.devide(20,2);

        //compare
        Assert.assertEquals(expected,actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDevideByZero(){
        Calculator calculator = new Calculator();
       // int expected = 10;

        calculator.devide(20,0);

        //compare
        //Assert.assertEquals(expected,actual);
    }
}
