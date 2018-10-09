package Collection;

/**
 * Created by dsk16 on 10/9/2018.
 */
public interface Queue {
    void enqueue(Object value);

    Object dequeue();

    Object peek() ;

    int size();

    // [A, B, C]
    public String toString();
}
