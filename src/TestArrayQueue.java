/**
 * Created by dsk16 on 10/8/2018.
 */
public class TestArrayQueue {
    public static void main(String[] args) {
        ArrayQueue aq = new ArrayQueue();
        //aq.dequeue();
        aq.enqueue(5);
        System.out.println(aq);
        aq.enqueue(6);
        aq.enqueue(8);
        aq.enqueue(7);
        System.out.println(aq);
        aq.dequeue();
        System.out.println(aq);
        aq.enqueue(11);
        aq.enqueue(12);
        System.out.println(aq.peek());
        System.out.println(aq);

    }

}

