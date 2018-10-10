package Tests;

import Collection.MyArrayListImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by dsk16 on 10/9/2018.
 */
public class MyArraListImlTest {

    @Before
    public void dobefore(){
        MyArrayListImpl<String> alSt = new MyArrayListImpl<>();
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

    }
}

