package Collection;

/**
 * Created by dsk16 on 10/8/2018.
 */
public class MyArrayListImpl implements List {
    Object[] array;
    int size;

    @Override
    public void add(Object value) {
        // size of newArray = array.length * 1.5
        array[size] = value;
        size++;
    }

    @Override
    public void add(Object value, int index) {
        if(index>=0 || index<=size){
            Object[] newArray;
            if(size==array.length){
                newArray = new Object[(int) (size /2*3+1)];

            }
            System.arraycopy(array,0,newArray,0,array.length);
            if(index<size){
                array[size] = value;
            }



            array[index]
        }else{
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
    }

    @Override
    public Object remove(int index) {
        return null;
    }

    @Override
    public Object get(int index) {
        return array[index];
    }

    @Override
    public Object set(Object value, int index) {
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object value) {
        return false;
    }

    @Override
    public int indexOf(Object value) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object value) {
        return 0;
    }
}
