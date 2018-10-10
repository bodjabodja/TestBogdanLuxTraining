package collection;

/**
 * Created by dsk16 on 10/9/2018.
 */
public class Calculator {

    public  int sum(int a, int b){
        return a+b;
    }

    public int devide(int a, int b){
        if(b==0){
            throw new IllegalArgumentException();
        }
        return a/b;
    }

}
