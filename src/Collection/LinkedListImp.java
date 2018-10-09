package Collection;

import com.study.List.*;
import com.study.List.Node;

import java.util.NoSuchElementException;

/**
 * Created by dsk16 on 10/9/2018.
 */
public class LinkedListImp implements List {
    com.study.List.Node head;
    com.study.List.Node tail;
    int size;


    @Override
    public void add(Object value) {
        com.study.List.Node newNode = new com.study.List.Node(value);
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

    //TODO:repair

    @Override
    public void add(Object value, int index) {
        com.study.List.Node newNode = new com.study.List.Node(value);
        if(index<0 && index>(size-1)){
            throw new IndexOutOfBoundsException("add by index is out of bounds!");
        }

        if(size==0){
            add(value);
        }else{

            if (index > 0 && index < (size - 1)) {
                Node current = getNode(index);
                Node prevCurrent = getNode(index - 1);
                prevCurrent.next = newNode;
                current.prev = newNode;
                newNode.prev = current;
                newNode.next = current;
            } else if (index == 0) {
                Node current = getNode(index);
                head=newNode;
                head.next=current;
                head.prev = null;
                current.prev = newNode;
                System.out.println(current.prev.value);
            } else if (index == (size - 1)) {
                Node prevCurrent = getNode(index - 1);
                prevCurrent.next = newNode;
                newNode.prev = prevCurrent;
                newNode.next = null;
            }
        }
        size++;

    }

    private com.study.List.Node getNode(int index){
        Node node = head;
        for (int i = 0; i <size ; i++) {
            if(i==index){
                return node;
            }
            node = node.next;
            i++;
        }
        throw new NoSuchElementException("asdgfdsg");

    }

    @Override
    public Object remove(int index) {
        if(index<0 && index>(size-1)){
            throw new IndexOutOfBoundsException("add by index is out of bounds!");
        }
        Node removeble = getNode(index);
        System.out.println(removeble.value);
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
        int i = 0;
        while(i != size){
            if(value.equals(node.value)){
                return i;
            }
            node = node.next;
            i++;
        }
        throw new NoSuchElementException("indexOf: no such element in list!");
    }

    @Override
    public int lastIndexOf(Object value) {
        Node node = head;
        int i = size-1;
        while(i != -1){
            if(value.equals(node.value)){
                return i;
            }
            node = node.prev;
            i--;
        }
        throw new NoSuchElementException("indexOf: no such element in list!");
    }
}
