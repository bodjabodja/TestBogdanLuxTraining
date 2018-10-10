package collection;

import java.util.NoSuchElementException;
import java.util.StringJoiner;

/**
 * Created by dsk16 on 10/9/2018.
 */
public class LinkedQueue implements Queue{
    Node first;
    int size;
    private Node tail;

    @Override
    public void enqueue(Object value) {
        Node newNode = new Node(value);
        if (size == 0) {
            first = newNode;
            tail = newNode;
            first.prev = tail;
        } else {
            tail.prev = newNode;
            tail = newNode;
        }

        size++;
    }

    @Override
    public Object dequeue() {
        if(size==0){
            throw new NoSuchElementException("There is now elements in LinkedQueue");
        }

        Node result = first;
        first=first.prev;
        size--;
        return result.value;
    }

    @Override
    public Object peek() {
        return first.value;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString(){
        StringJoiner strJ = new StringJoiner(",","[","]");
        Node node = first;
        for (int i = 0; i <size ; i++) {

            String value = String.valueOf(node.value);
            strJ.add(value);
            node = node.prev;
        }
        return strJ.toString();
    }
}
