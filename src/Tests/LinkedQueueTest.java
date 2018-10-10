package Tests;

/**
 * Created by dsk16 on 10/9/2018.
 */

import collection.LinkedQueue;
import org.junit.Assert;
import org.junit.Test;

import java.util.NoSuchElementException;

public class LinkedQueueTest {


    @Test
    public void dequeueTest(){
        LinkedQueue lq = new LinkedQueue();
        int expected = 5;
        lq.enqueue(expected);

        Assert.assertEquals(expected,lq.dequeue());
    }

    @Test(expected = NoSuchElementException.class)
    public void dequeTestForNull(){
        LinkedQueue lq = new LinkedQueue();
        lq.dequeue();
    }

    @Test
    public void enqueueTest(){
        LinkedQueue lq = new LinkedQueue();
        int expected = 6;
        lq.enqueue(5);
        lq.enqueue(7);
        lq.enqueue(expected);
        lq.dequeue();
        lq.dequeue();

        Assert.assertEquals(expected,lq.dequeue());
    }

    @Test
    public void peekTest(){
        LinkedQueue lq = new LinkedQueue();
        int expected = 6;
        lq.enqueue(4);
        lq.enqueue(5);
        lq.enqueue(expected);
        lq.dequeue();
        lq.dequeue();

        Assert.assertEquals(expected,lq.peek());

    }

    @Test
    public void sizeTest(){
        LinkedQueue lq = new LinkedQueue();
        int expected = 1;
        lq.enqueue(1);

        Assert.assertEquals(expected,lq.size());

    }
}
