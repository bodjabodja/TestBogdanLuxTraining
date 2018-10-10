package collection;

public class TryArrayList {
    public static void main(String[] args) {
        MyArrayListImpl arl = new MyArrayListImpl();
        arl.add(5);
        arl.add(6,1);
        System.out.println(arl.size);
    }
}
