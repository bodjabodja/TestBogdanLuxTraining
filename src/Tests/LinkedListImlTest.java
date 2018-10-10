package Tests;

import collection.LinkedListImp;
import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;

/**
 * Created by dsk16 on 10/9/2018.
 */
public class LinkedListImlTest {

    @Test
    public void addByValueTest(){
        LinkedListImp ll = new LinkedListImp();
        int expected = 6;
        ll.add(expected);

        Assert.assertEquals(expected,ll.get(0));
    }

    @Test
    public void addByIndexTest(){
        LinkedListImp ll = new LinkedListImp();
        int index = 1;
        int expected = 10;
        ll.add(6);
        ll.add(5);
        ll.add(7);
        ll.add(expected,index);


        Assert.assertEquals(expected,ll.get(index));
    }

    @Test
    public void removeTest(){
        LinkedListImp ll = new LinkedListImp();
        int expected = 5;
        ll.add(6);
        ll.add(5);
        ll.add(7);
        ll.remove(0);

        Assert.assertEquals(expected,ll.get(0));
    }

    @Test
    public void iteratorTest(){
        LinkedListImp ll = new LinkedListImp();
        for (int i = 0; i < 5; i++) {
            ll.add(i);
        }
        Iterator it = ll.iterator();
        for (int i = 0; i < 5; i++) {
            Assert.assertEquals(true,it.hasNext());

            Assert.assertEquals(i,it.next());

        }
    }

}
