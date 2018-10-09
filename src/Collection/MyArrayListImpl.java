package Collection;

import java.util.NoSuchElementException;
import java.util.StringJoiner;

/**
 * Created by dsk16 on 10/8/2018.
 */
public class MyArrayListImpl implements List {
    Object[] array;
    int size;

    static  final int INITIAL_CAPACITY = 5;

    MyArrayListImpl(){
        array = new Object[INITIAL_CAPACITY];
    }

    @Override
    public void add(Object value) {
        // size of newArray = array.length * 1.5
        if(size==array.length){
            Object[] newArray = new Object[(int) (size /2*3+1)];
            System.arraycopy(array,0,newArray,0,array.length);
        }
        array[size] = value;
        size++;
    }

    @Override
    public void add(Object value, int index) {
        if(index>=0 && index<=size-1){

            if(size==array.length){
                Object[] newArray = new Object[(int) (size /2*3+1)];
                System.arraycopy(array,0,newArray,0,array.length);
            }

            if(index==size){
                array[index]=value;
            } else if(index==0){
                System.arraycopy(array,0,array,1,array.length);
                array[index]=value;
            }else {
                Object[] tmpArray = new Object[(int) (size - index)];
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
    public Object remove(int index) {
        if(index>=0 && index<=size-1){
            Object removeObj = array[index];
            Object[] tmpArray = new Object[(int) size-index-1];
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
    public Object get(int index) {
        return array[index];
    }

    @Override
    public Object set(Object value, int index) {
        if(index>=0 && index<=size-1){
            array[index]=value;
            return  array[index];
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
    public boolean contains(Object value) {
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
    public int lastIndexOf(Object value) {
        for (int i = size-1; i >=0 ; i--) {
            if(array[i] == value){
                return i;
            }
        }

        throw new NoSuchElementException("There is no such element with input value in Array!");
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
            strJ.add(value.toString());
        }
        return strJ.toString();
    }
}
