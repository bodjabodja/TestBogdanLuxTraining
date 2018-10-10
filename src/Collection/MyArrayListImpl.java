package Collection;
//FIFO


import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.StringJoiner;

/**
 * Created by dsk16 on 10/8/2018.
 */
public class MyArrayListImpl<E> implements List<E>, Iterable {
    private Object[] array;
    int size;

    private static  final int INITIAL_CAPACITY = 5;

    public MyArrayListImpl(){
        array = new Object[INITIAL_CAPACITY];
    }

    @Override
    public void add(E value) {
        if(size==array.length){
            Object[] newArray;
            newArray = new Object[size /2*3+1];
            System.arraycopy(array,0,newArray,0,array.length);
        }
        array[size] = value;
        size++;
    }

    @Override
    public void add(E value, int index) {
        if(index>=0 && index<=size-1){

            if(size==array.length){
                Object[] newArray;
                newArray = new Object[size /2*3+1];
                System.arraycopy(array,0,newArray,0,array.length);
            }

            if(index==size){
                array[index]=value;
            } else if(index==0){
                System.arraycopy(array,0,array,1,array.length);
                array[index]=value;
            }else {
                Object[] tmpArray = new Object[size - index];
                System.arraycopy(array, index, tmpArray, 0, size - index);
                array[index] = value;
                System.arraycopy(tmpArray, 0, array, index + 1, size - index);
            }
            size++;
        }else{
            throw new IndexOutOfBoundsException("add.Index out of bounds!");
        }
    }

    @Override
    public E remove(int index) {
        if(index>=0 && index<=size-1){
            @SuppressWarnings("unchecked")
            E removeObj = (E) array[index];
            Object[] tmpArray = new Object[size-index-1];
            System.arraycopy(array, index+1, tmpArray, 0, size-index-1);
            System.arraycopy(tmpArray, 0, array, index, size-index-1);
            array[size-1]=null;
            size--;
            return removeObj;
        }else {
            throw new NoSuchElementException("remove.index of element out of bounds!");
        }
    }

    @Override
    public E get(int index) {
        @SuppressWarnings("unchecked")
        E res = (E) array[index];
        return res;
    }

    @Override
    public E set(E value, int index) {
        if(index>=0 && index<=size-1){
            array[index]=value;

            @SuppressWarnings("unchecked")
            E res = (E) array[index];
            return  res;
        }else{
            throw new NoSuchElementException("index of element out of bounds!");
        }
    }

    @Override
    public void clear() {
        for (int i=0;i<size;i++) {
            array[i]=null;
        }
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
    public boolean contains(E value) {
        return indexOf(value) != -1;
    }

    @Override
    public int indexOf(Object value) {
        for (int i = 0; i <size ; i++) {
            if(value.equals(array[i])){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(E value) {
        for (int i = size-1; i >=0 ; i--) {
            if(array[i] == value){
                return i;
            }
        }

        throw new NoSuchElementException("There is no such element with input value in Array!");
    }

    @Override
    public Iterator iterator(){
        return new MyIterator();
    }

    private class MyIterator implements Iterator{
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index!=size;
        }

        @Override
        public Object next() {
            @SuppressWarnings("unchecked")
            E res = (E) array[index];
            index++;
            return res;
        }
    }

    @Override
    public String toString() {
//        String result = "[";
//        for (int i=0;i<size;i++) {
//            result+=array[i]+",";
//        }
//        result = result.substring(0,result.length()-1);
//        result+="]";
//        return result;
        StringJoiner strJ = new StringJoiner(",","{","]");
        for (int i = 0; i < size ; i++) {
            String value = String.valueOf(array[i]);
            strJ.add(value);
        }
        return strJ.toString();
    }
}
