package Collection;

/**
 * Created by dsk16 on 10/9/2018.
 */
public class LinkedQueueMain {
    public static void main(String[] args) {
        LinkedQueue lq = new LinkedQueue();
        lq.enqueue(5);
        lq.enqueue(7);
        lq.enqueue(10);
        System.out.println(lq.peek());
        System.out.println(lq.dequeue());
        System.out.println(lq.dequeue());
        System.out.println(lq.peek());

        lq.enqueue(9);

        lq.dequeue();
        System.out.println(lq.peek());
        System.out.println(lq.toString());

    }
}
