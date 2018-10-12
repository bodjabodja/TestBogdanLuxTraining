package reflection.main;

import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by dsk16 on 10/12/2018.
 */
public class ReflectionTraining {

    public static void callObjectMethodsWithNoParams(Object value) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Class clazz = value.getClass();
        Object clObj = clazz.newInstance();
        Method[] mss = clazz.getDeclaredMethods();
        Method[] ms = clazz.getMethods();
        for (Method  m : mss ) {
            if(m.getParameterCount()==0){
             Object ob = m.invoke(clObj);
             System.out.println(ob.toString());
            }
        }
    }

    public static void callObjectMethodsSings(Object value) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Class clazz = value.getClass();
        //Object clObj = clazz.newInstance();
        //Method[] mss = clazz.getDeclaredMethods();
        Method[] ms = clazz.getMethods();
        for (Method  m : ms ) {
            if(m.toString().contains("final")){
             //Object ob = m.invoke(clObj);
             //System.out.println(ob.toString());
            System.out.println(m.toString());
            }
        }
    }

    public static List<String> returnExtendsAndImplments(Class clazz) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        //Class clazz = value.getClass();
        //Object clObj = clazz.newInstance();
        //Method[] mss = clazz.getDeclaredMethods();
        List<String> list = new ArrayList<>();
        Class[] at = clazz.getInterfaces();
        for (Class  m : at ) {
            list.add(m.toString());
//            if(m.toString().contains("final")){
//                //Object ob = m.invoke(clObj);
//                //System.out.println(ob.toString());
//                System.out.println(m.toString());
//            }
        }

        Class[] at1 = clazz.getClasses();
        for (Class c: at1 ) {
            list.add(c.toString());
        }
        return list;
    }

    public static void resetFieldsValues(Object value) throws IllegalAccessException {

        Field[] fields = value.getClass().getDeclaredFields();
        for (Field f: fields ) {
            f.setAccessible(true);
            Class<?> type = f.getType();
            if(!type.isPrimitive()){
                f.set(value,null);
            } else if (type == boolean.class){
                f.setBoolean(value,false);
            } else {
                f.set(value,0);
            }
            f.setAccessible(false);
        }

    }

    public static void main(String[] args) throws InstantiationException, IllegalAccessException, InvocationTargetException {
       ReflectionTraining.callObjectMethodsWithNoParams("asdfas");
       ReflectionTraining.callObjectMethodsSings("asdfas");
        System.out.println(ReflectionTraining.returnExtendsAndImplments("asdfas".getClass()).size());
    }
}
