package Tests;

import collection.MyArrayListImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertEquals;

/**
 * Created by dsk16 on 10/9/2018.
 */
public class MyArraListImlTest {
    MyArrayListImpl<String> alSt;
    @Before
    public void dobefore(){
        alSt = new MyArrayListImpl<>();
        for (int i = 0; i < 5; i++) {
            alSt.add("str"+i);
        }
    }

    @Test
    public void iteratorHasNextTest(){
        MyArrayListImpl al = new MyArrayListImpl();
        al.add(5);
        al.add(6);
        Iterator it = al.iterator();
        Assert.assertEquals(true,it.hasNext());

    }

    @Test
    public void iteratorNextTest(){
        MyArrayListImpl al = new MyArrayListImpl();
        for (int i = 0; i < 5; i++) {
            al.add(i);
        }
        Iterator it = al.iterator();
        for (int i = 0; i < 5; i++) {
            Assert.assertEquals(i,it.next());
        }
    }

    @Test
    public void removeTest(){
        for (int i = 0; i < 4; i++) {
            alSt.remove(0);
            Assert.assertEquals(alSt.get(0),"str"+(i+1));
        }

    }
}

