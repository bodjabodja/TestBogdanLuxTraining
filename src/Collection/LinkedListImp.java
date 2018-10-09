package Collection;




import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.StringJoiner;

/**
 * Created by dsk16 on 10/9/2018.
 */
public class LinkedListImp implements List {
   private Node head;
    private Node tail;
    private int size;

    private static class Node {
        private Object value;
        private Node next;
        private Node prev;

        private Node(Object value) {
            this.value = value;
        }
    }

    @Override
    public void add(Object value) {
        Node newNode = new Node(value);
        if(size==0){
            head=newNode;
            newNode.prev=tail;
            tail=newNode;
            head.next=tail;
        }else{
            tail.next = newNode;
            newNode.prev=tail;
            tail = newNode;
        }
        size++;
    }

    @Override
    public void add(Object value, int index) {
        Node newNode = new Node(value);
        if(index<0 || index>(size)){
            throw new IndexOutOfBoundsException("add by index is out of bounds!");
        }

        if(size==0){
            add(value);
        }else{
            if (index > 0 && index < (size-1)) {
                Node current = getNode(index);
                Node prevCurrent = getNode(index - 1);
                prevCurrent.next = newNode;
                current.prev = newNode;
                newNode.prev = current;
                newNode.next = current;
                size++;
            } else if (index == 0) {
                Node current = getNode(index);
                head=newNode;
                head.next=current;
                head.prev = null;
                current.prev = newNode;
                size++;
            } else if (index == (size - 1)) {
                Node prevCurrent = getNode(index - 1);
                prevCurrent.next = newNode;
                newNode.prev = prevCurrent;
                newNode.next = null;
                size++;
            } else if (index == size){
                add(value);
            }
        }


    }

    private Node getNode(int index){
        Node node = head;
        for (int i = 0; i <size ; i++) {
            if(i==index){
                return node;
            }
            node = node.next;

        }
        throw new IndexOutOfBoundsException("asdgfdsg");

    }

    @Override
    public Object remove(int index) {
        if(index<0 && index>(size-1)){
            throw new IndexOutOfBoundsException("add by index is out of bounds!");
        }
        Node removeble = getNode(index);
        if (index > 0 && index < size - 1) {
            Node prevRem = getNode(index-1);
            Node newxtRem = getNode(index + 1);
            prevRem.next = newxtRem;
            newxtRem.prev = prevRem;
        }else if(index == 0){
            head= getNode(index + 1);
            head.prev=null;
        }else {
            tail = getNode(index-1);
            tail.next=null;
        }


        size--;
        return removeble.value;
    }

    @Override
    public Object get(int index) {
        return getNode(index).value;
    }

    @Override
    public Object set(Object value, int index) {
        Node current = getNode(index);
        current.value=value;
        return current.value;
    }

    @Override
    public void clear() {
        head=tail=null;
        size=0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object value) {
        Node node = head;
        for (int i = 0; i <size ; i++) {
            if(value.equals(node.value)){
                return true;
            }
            node=node.next;
        }
        return false;
    }

    @Override
    public int indexOf(Object value) {
        Node node = head;
        for (int i = 0; i <size ; i++) {
            if(value == node.value){
                return i;
            }
            node = node.next;

        }

        return -1;
    }

    @Override
    public int lastIndexOf(Object value) {
        Node node = tail;
        for (int i = size-1; i >=0 ; i--) {
            if(value == node.value){
                return i;
            }
            node = node.prev;

        }
        return -1;
    }

    @Override
    public String toString(){
        StringJoiner strJ = new StringJoiner(",","[","]");
        Node node = head;
        for (int i = 0; i <size ; i++) {

            String value = String.valueOf(node.value);
            strJ.add(value);
            node = node.next;
        }
        return strJ.toString();
    }

    public Iterator iterator(){
        return new MyIterator();
    }

    private class MyIterator implements Iterator{
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index<=size;
        }

        @Override
        public Object next() {
            Node node = getNode(index);
            index++;
            return node.value;
        }
    }
}
