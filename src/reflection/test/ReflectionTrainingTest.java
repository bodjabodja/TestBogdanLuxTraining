package reflection.test;

import org.junit.Test;
import reflection.main.ReflectionTraining;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertNull;

/**
 * Created by dsk16 on 10/12/2018.
 */
public class ReflectionTrainingTest {
    @Test
    public void resetFieldsValuesTest() throws IllegalAccessException {
        TestVO testVO = new TestVO("bb",15,true);
        ReflectionTraining.resetFieldsValues(testVO);
        assertNull(testVO.name);
        assertEquals(0,testVO.age);
        assertFalse(testVO.married);
    }
}

class TestVO{
    String name;
    int age;
    boolean married;

    public TestVO(String name, int age, boolean married){
        this.name=name;
        this.age=age;
        this.married=married;
    }
}