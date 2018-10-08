import java.util.NoSuchElementException;

/**
 * Created by dsk16 on 10/8/2018.
 */
public class ArrayQueue {
    Object[] array;
    int size;

    ArrayQueue(){
        array = new Object[5];
    }

    void enqueue(Object value) {
        if (size == array.length) {
            Object[] newArray = new Object[(int) (size /2*3+1)];
            System.arraycopy(array,0,newArray,0,array.length);
//
//            for (int i = 0; i < array.length; i++) {
//                newArray[i] = array[i];
//            }
//
//            array = newArray;
        }
        array[size] = value;
        size++;
    }

    Object dequeue() {
        if(size==0){
            throw new NoSuchElementException("Queue is empty!");
        }
        Object result = array[0];

//        for (int i=1; i<size;i++) {
//            array[i-1] = array[i];
//        }
        System.arraycopy(array,1,array,0,array.length-1);
        array[size-1]=null;
        size--;
        return result;
    }

    Object peek() {
        return array[0];
    }

    int size() {
        return size;
    }

    // [A, B, C]
    public String toString() {
        String result = "[";
        for (int i=0;i<size;i++) {
            result+=array[i]+",";
        }
        result = result.substring(0,result.length()-1);
        result+="]";
        return result;
    }
}
